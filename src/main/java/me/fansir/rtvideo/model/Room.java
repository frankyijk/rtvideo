package me.fansir.rtvideo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class Room implements Serializable {
    @Getter
    @Setter
    private String rtmpUrl; // 推流地址
    @Getter
    @Setter
    private String name;    // 房间名称

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room{")
            .append("rtmpUrl=").append(rtmpUrl)
            .append(", name=").append(name)
            .append('}');
        return sb.toString();
    }
}
