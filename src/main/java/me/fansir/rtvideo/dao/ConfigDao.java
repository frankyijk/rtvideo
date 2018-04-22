package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.model.Category;
import me.fansir.rtvideo.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface ConfigDao {

    @Select("select * from role where id=#{id}")
    Role getRoleById(@Param("id") Integer id);

    @Select("select * from role")
    List<Role> listAllRole();

    @Select("select * from category")
    List<Category> listAllCategory();

    @Select("select * from category where id=#{id}")
    Category getCategoryById(@Param("id") Integer id);

    @Select("select rtmpUrl from server")
    List<String> listRtmpServerUrl();
}
