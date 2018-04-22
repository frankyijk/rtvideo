package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.dao.RoleDao;
import me.fansir.rtvideo.model.Role;
import me.fansir.rtvideo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> listRoleByUserId(Long uid) {
        return roleDao.listRoleIdByUserId(uid);
    }

    @Override
    public Long countUserByRoleId(Integer roleId) {
        return roleDao.countUserByRoleId(roleId);
    }

    @Override
    public void addUserRole(Long uid, Integer roleId) {
        roleDao.addUserRole(uid, roleId);
    }
}
