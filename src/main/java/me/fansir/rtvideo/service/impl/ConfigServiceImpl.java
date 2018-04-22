package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.dao.ConfigDao;
import me.fansir.rtvideo.model.Category;
import me.fansir.rtvideo.model.Role;
import me.fansir.rtvideo.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigDao configDao;

    @Override
    public Role getRoleById(Integer id) {
        return configDao.getRoleById(id);
    }

    @Override
    public List<Role> listAllRole() {
        return configDao.listAllRole();
    }

    @Override
    public List<Category> listAllCategory() {
        return configDao.listAllCategory();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return configDao.getCategoryById(id);
    }

    @Override
    public List<String> listRtmpServerUrl() {
        return configDao.listRtmpServerUrl();
    }

    @Override
    public String getDashServerUrl() {
        return "http://localhost/dash/";
    }

    @Override
    public String getFlvOverHttpUrl() {
        return "http://localhost:8081/flv-http/";
    }
}
