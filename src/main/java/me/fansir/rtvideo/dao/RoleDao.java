package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface RoleDao {

    @Select("select role.id,role.name from (select * from user_role where user_id=#{uid}) as A join role on A.role_id=role.id")
    List<Role> listRoleIdByUserId(@Param("uid") Long uid);

    @Select("select count(user_id) from user_role where role_id=#{roleId}")
    Long countUserByRoleId(@Param("roleId") Integer roleId);

    @Insert("insert into user_role(user_id, role_id) values (#{uid}, #{rid})")
    void addUserRole(@Param("uid") Long uid, @Param("rid") Integer rid);

    @Delete("delete from user_role where user_id=#{uid} and role_id=#{rid}")
    void deleteUserRole(@Param("uid") Long uid, @Param("rid") Integer rid);
}