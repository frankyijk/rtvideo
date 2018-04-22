package me.fansir.rtvideo.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class VideoSearchBean implements Serializable {
    private Long    videoId;
    private Long    ownerId;
    private Integer cateId;
    private Integer state;
    private Boolean islive;
    private Date    ltime;
    private Date    rtime;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoSearchBean{")
            .append("videoId=").append(videoId)
            .append(", ownerId=").append(ownerId)
            .append(", cateId=").append(cateId)
            .append(", state=").append(state)
            .append(", islive=").append(islive)
            .append(", ltime=").append(ltime)
            .append(", rtime=").append(rtime)
        .append('}');
        return sb.toString();
    }
}
