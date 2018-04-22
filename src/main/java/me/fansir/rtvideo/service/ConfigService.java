package me.fansir.rtvideo.service;

import me.fansir.rtvideo.model.Category;
import me.fansir.rtvideo.model.Role;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface ConfigService {

    /**
     * 根据系统角色 ID 返回 {@link Role}
     * @param id
     *
     * @return {@link Role}
     */
    Role getRoleById(Integer id);

    /**
     * 返回系统内存在的所有角色列表
     *
     * @return list of {@link Role}
     */
    List<Role> listAllRole();

    /**
     * 返回系统内视频类别列表
     *
     * @return list of {@link Category}
     */
    List<Category> listAllCategory();

    /**
     * 根据视频列别 ID 获取列表信息
     * @param id
     *
     * @return {@link Role}
     */
    Category getCategoryById(Integer id);

    /**
     * 返回直播系统内所有 RTMP 流服务地址
     *
     * @return list of {@link String}
     */
    List<String> listRtmpServerUrl();

    String getDashServerUrl();

    String getFlvOverHttpUrl();
}
