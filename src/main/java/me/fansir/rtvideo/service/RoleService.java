package me.fansir.rtvideo.service;

import me.fansir.rtvideo.model.Role;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface RoleService {
    List<Role> listRoleByUserId(Long uid);
    Long countUserByRoleId(Integer roleId);
    void addUserRole(Long uid, Integer roleId);
}
