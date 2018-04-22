package me.fansir.rtvideo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class Subscribe implements Serializable {

    private Long    id;
    private Long    viewerId;
    private Long    ownerId;
    private Integer state;
    private Date    gmt_create;
    private Date    gmt_modified;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subscribe{")
            .append("id=").append(id)
            .append(", viewerId=").append(viewerId)
            .append(", ownerId=").append(ownerId)
            .append(", state=").append(state)
            .append(", gmt_create=").append(gmt_create)
            .append(", gmt_modified=").append(gmt_modified)
            .append('}');
        return sb.toString();
    }
}
