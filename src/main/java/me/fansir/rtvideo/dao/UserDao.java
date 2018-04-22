package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.dao.provider.UserDynamicSqlProvider;
import me.fansir.rtvideo.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface UserDao {

    @Insert("insert into user(username, nickname, password, gmt_create, gmt_modified)" +
            "values (#{username}, #{nickname}, #{password}, sysdate(), sysdate())")
    @Options(useGeneratedKeys = true)
    void save(User user);

    @UpdateProvider(type = UserDynamicSqlProvider.class, method = "updateUser")
    void update(User user);

    @Results(id = "userWithRoleListMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "id", property = "roleList",
            many = @Many(select = "me.fansir.rtvideo.dao.RoleDao.listRoleIdByUserId"))
    })
    @Select("select user.id,user.username,user.password,user.phone,user.nickname,user.gender,user.avatar" +
            " from user where id=#{id}")
    User getUserById(@Param("id") Long id);

    @ResultMap("userWithRoleListMap")
    @Select("select user.id,user.username,user.password,user.phone,user.nickname,user.gender,user.avatar" +
            " from user where username=#{username}")
    User getUserByUserName(@Param("username") String username);

    @Update("update user set enabled=false where id=#{uid}")
    void deleteUser(@Param("uid") Long uid);

//    @Select("<script> select count(*) from user where <if")
//    Integer countUserByParam(UserSearchBean searchBean);
}
