package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.constant.CommonRes;
import me.fansir.rtvideo.constant.IRequestMapping;
import me.fansir.rtvideo.constant.UserRoleEnum;
import me.fansir.rtvideo.model.User;
import me.fansir.rtvideo.service.RoleService;
import me.fansir.rtvideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, Model model) {
        if (userService.getUserByUsername(userForm.getUsername()) != null) {
            model.addAttribute("error", true);
            model.addAttribute("msg", "用户名已存在");
            return "/registration";
        }
        Long uid = userService.addUser(userForm);   // 用户表新增
        roleService.addUserRole(uid, UserRoleEnum.ROLE_VIEWER.getId()); // 用户添加 VIEWER 权限

        model.addAttribute("registration", true);
        return "login";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserInfoById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping(value = IRequestMapping.API_VIEWER_APPLY)
    @ResponseBody
    public CommonRes applyUploaderRole(Long uid) {
        roleService.addUserRole(uid, UserRoleEnum.ROLE_UPLOADER.getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
        updatedAuthorities.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_UPLOADER.name()));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        return CommonRes.retOk();
    }
}
