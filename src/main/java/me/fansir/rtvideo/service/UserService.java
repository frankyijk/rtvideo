package me.fansir.rtvideo.service;

import me.fansir.rtvideo.bean.UserSearchBean;
import me.fansir.rtvideo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface UserService extends UserDetailsService {
    User getUserByUsername(String username);
    User getUserById(Long id);
    Long addUser(User user);
    void updateUser(User user);
    void deleteUser(Long uid);
    Integer countUserByParam(UserSearchBean searchBean);
}
