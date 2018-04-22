package me.fansir.rtvideo.model;

import lombok.Getter;
import lombok.Setter;
import me.fansir.rtvideo.constant.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class User implements UserDetails {

    @Getter
    @Setter
    private Long    id;
    @Getter
    @Setter
    private String  phone;
    @Getter
    @Setter
    private String  avatar;
    @Getter
    @Setter
    private String  username;
    @Getter
    @Setter
    private String  password;
    @Getter
    @Setter
    private String  nickname;
    @Getter
    @Setter
    private Integer gender;
    @Getter
    @Setter
    private Boolean locked;
    @Setter
    private Boolean enabled;    // 删除帐号后为 false
    @Getter
    @Setter
    private List<Role> roleList;
    @Getter
    @Setter
    private Date    gmt_create;
    @Getter
    @Setter
    private Date    gmt_modified;
    public User() {
        this.locked     = Boolean.FALSE;
        this.enabled    = Boolean.TRUE;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roleList == null || roleList.isEmpty()) {
            roleList = new ArrayList<>(1);
            roleList.add(new Role(UserRoleEnum.ROLE_VIEWER.getId(), UserRoleEnum.ROLE_VIEWER.toString()));
        }

        List<GrantedAuthority> authorities = roleList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{")
                .append("id=").append(id)
                .append(", phone=").append(phone)
                .append(", username=").append(username)
                .append(", avatar=").append(avatar)
                .append(", password=[PROTECTED]")
                .append(", nickname='").append(nickname)
                .append(", gender=").append(gender)
                .append(", gmt_create=").append(gmt_create)
                .append(", gmt_modified=").append(gmt_modified)
                .append('}');
        return sb.toString();
    }

}