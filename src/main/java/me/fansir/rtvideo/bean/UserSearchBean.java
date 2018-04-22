package me.fansir.rtvideo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class UserSearchBean implements Serializable {
    private String  phone;
    private String  username;
    private String  nickname;
    private Integer gender;
    private Boolean locked;
    private Boolean enabled;
    private Date    gmt_create;
    private Date    gmt_modified;
}
