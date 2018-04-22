package me.fansir.rtvideo.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class VideoItemBean implements Serializable {
    private Long    videoId;
    private String  videoName;
    private String  rtmpUrl;    // 直播流地址
    private String  flvUrl;     // 静态视频文件地址
    private String  thumbnail;
    private Integer uv;
    private Integer pv;
    private String  tags;
    private Long    ownerId;    // 主播ID
    private Boolean islive;     // 是否正在直播
    private Integer categoryId;
    private String  categoryName;
    private String  ownerNickname;
    private Integer roomName;
}
