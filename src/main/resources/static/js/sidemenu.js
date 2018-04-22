/**
 * BootSideMenu v 2.0
 * Author: Andrea Lombardo
 * http://www.lombardoandrea.com
 * https://github.com/AndreaLombardo/BootSideMenu
 * */
(function ($) {

    $.fn.BootSideMenu = function (userOptions) {

        var initialCode;
        var newCode;
        var $menu;
        var bodyProperties = {};

        var $DOMBody = $("body", document);

        var defaults = {
            side: "left",
            duration: 500,
            icons: {
                left: 'glyphicon glyphicon-chevron-left',
                right: 'glyphicon glyphicon-chevron-right',
            },
            width: "210px"
        };

        var options = $.extend({}, defaults, userOptions);


        bodyProperties['originalMarginLeft'] = $DOMBody.css("margin-left");
        bodyProperties['originalMarginRight'] = $DOMBody.css("margin-right");
        bodyProperties['width'] = $DOMBody.width();

        initialCode = this.html();

        newCode = '<div class="menu-wrapper">' + initialCode + '</div>';
        newCode += '<div class="toggler" data-whois="toggler">';
        newCode += '<span class="icon"></span>';
        newCode += '</div>';

        this.empty();
        this.html(newCode);

        $menu = $(this);

        $menu.addClass("container");
        $menu.addClass("bootsidemenu");
        $menu.css("width", options.width);

        if (options.side === "left") {
            $menu.addClass("bootsidemenu-left");
        } else if (options.side === "right") {
            $menu.addClass("bootsidemenu-right");
        }

        $menu.id = $menu.attr("id");
        $menu.toggler = $menu.find('[data-whois="toggler"]');


        startDefault();

        $menu.off('click', '.toggler[data-whois="toggler"]', toggle);
        $menu.on('click', '.toggler[data-whois="toggler"]', toggle);

        $menu.off('click', '.entrance-item');
        $menu.on('click', '.entrance-item', function () {
            $menu.find(".entrance-item").each(function () {
                $(this).removeClass("active");
            });
            $(this).addClass('active');
            $.cookie('active-menu', $(this).id);
        });

        $menu.off('click', 'a:not(.entrance-item)');
        $menu.on('click', 'a:not(.entrance-item)', function () {
            $menu.find(".entrance-item").each(function () {
                $(this).removeClass("active");
                $.cookie('active-menu', null);
            });
        });

        $menu.off('click', '.sidebar-userinfo-myfollow');
        $menu.on('click', '.sidebar-userinfo-myfollow', function () {
            $("#entrance-item-myfollow").addClass("active");
        });

        $menu.off('mouseenter', '.sidebar-userinfo');
        $menu.on('mouseenter', '.sidebar-userinfo', function () {
            $(this).removeClass("sidebar-userinfo-expanded");
            $(this).addClass('sidebar-userinfo-expanded');
        });

        $menu.off('mouseleave', '.sidebar-userinfo');
        $menu.on('mouseleave', '.sidebar-userinfo', function () {
            $(this).removeClass("sidebar-userinfo-expanded");
        });


        function toggle() {
            if ($menu.status === "opened") {
                closeMenu();
            } else {
                openMenu();
            }
        }

        function switchArrow(side) {
            var $icon = $menu.toggler.find(".icon");

            $icon.removeClass();

            if (side === "left") {
                $icon.addClass(options.icons.right);
            } else if (side === "right") {
                $icon.addClass(options.icons.left);
            }

            $icon.addClass('icon');
        }

        function startDefault() {
            if (options.side === "left") {
                switchArrow("right");
                $DOMBody.css("margin-left", $menu.width() + 30);
            } else if (options.side === "right") {
                switchArrow("left");
                $DOMBody.css("margin-right", $menu.width() + 30);
            }
        }

        function closeMenu() {

            if (options.side === "left") {

                $DOMBody.animate({marginLeft: bodyProperties.originalMarginLeft}, {duration: options.duration});

                $menu.animate({
                    left: -($menu.width() + 2)
                }, {
                    duration: options.duration,
                    done: function () {
                        switchArrow("left");
                        $menu.status = "closed";
                    }
                });
            } else if (options.side === "right") {

                $DOMBody.animate({marginRight: bodyProperties.originalMarginRight}, {duration: options.duration});

                $menu.animate({
                    right: -($menu.width() + 2)
                }, {
                    duration: options.duration,
                    done: function () {
                        switchArrow("right");
                        $menu.status = "closed";
                    }
                });
            }

        }

        function openMenu() {

            if (options.side === "left") {

                $DOMBody.animate({marginLeft: $menu.width() + 30}, {duration: options.duration});

                $menu.animate({
                    left: 0
                }, {
                    duration: options.duration,
                    done: function () {
                        switchArrow("right");
                        $menu.status = "opened";
                    }
                });
            } else if (options.side === "right") {

                $DOMBody.animate({marginRight: $menu.width() + 30}, {duration: options.duration});

                $menu.animate({
                    right: 0
                }, {
                    duration: options.duration,
                    done: function () {
                        switchArrow("left");
                        $menu.status = "opened";
                    }
                });
            }
        }


        $.fn.BootSideMenu.open = function () {
            openMenu();
        };

        $.fn.BootSideMenu.close = function () {
            closeMenu();
        };

        $.fn.BootSideMenu.toggle = function () {
            toggle();
        };

        return this;

    }
}(jQuery));