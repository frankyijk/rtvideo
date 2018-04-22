package me.fansir.rtvideo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class Record implements Serializable {
    private Long    id;
    private Long    userId;
    private Long    videoId;
    private Integer state;
    private Date    gmt_create;
    private Date    gmt_modified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Record{")
            .append("id=").append(id)
            .append(", uid=").append(userId)
            .append(", vid=").append(videoId)
            .append(", state=").append(state)
            .append(", gmt_create=").append(gmt_create)
            .append(", gmt_modified=").append(gmt_modified)
            .append('}');
        return sb.toString();
    }
}
