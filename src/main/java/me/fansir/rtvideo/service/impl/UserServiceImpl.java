package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.bean.UserSearchBean;
import me.fansir.rtvideo.dao.UserDao;
import me.fansir.rtvideo.model.User;
import me.fansir.rtvideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Long addUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userDao.save(user);
        return user.getId();
    }

    @Override
    public void updateUser(User user) {
        if (user == null || user.getId() == null) {
            return;
        }
        userDao.update(user);
    }

    @Override
    public void deleteUser(Long uid) {
        userDao.deleteUser(uid);
    }

    @Override
    public Integer countUserByParam(UserSearchBean searchBean) {
        return null;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
