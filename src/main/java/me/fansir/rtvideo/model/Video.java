package me.fansir.rtvideo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class Video implements Serializable {

    public Video() {}
    public Video(Long id) {
        this.id = id;
    }
    private Long    id;
    private String  name;
    private String  rtmpUrl;    // 直播流地址
    private String  flvUrl;     // 静态视频文件地址
    private String  thumbnail;
    private Integer categoryId;
    private Integer uv;
    private Integer pv;
    private String  tags;
    private Long    ownerId;    // 主播ID
    private Boolean islive;     // 是否正在直播
    private Integer state;      // 管理员鉴定结构，正常、不可见
    private Date    gmt_create;
    private Date    gmt_modified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Video{")
            .append("id=").append(id)
            .append(", name=").append(name)
            .append(", rtmpUrl=").append(rtmpUrl)
            .append(", flvUrl=").append(flvUrl)
            .append(", thumbnail=").append(thumbnail)
            .append(", categoryId=").append(categoryId)
            .append(", uv=").append(uv)
            .append(", pv=").append(pv)
            .append(", tags=").append(tags)
            .append(", islive=").append(islive)
            .append(", state=").append(state)
            .append('}');
        return sb.toString();
    }
}
