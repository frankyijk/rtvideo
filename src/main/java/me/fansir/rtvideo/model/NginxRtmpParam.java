package me.fansir.rtvideo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Data
public class NginxRtmpParam implements Serializable {
    private String call;
    private String app;
    private String name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NginxRtmpParam{")
            .append("call=").append(call)
            .append(", app=").append(app)
            .append(", name=").append(name)
            .append('}');
        return sb.toString();
    }
}
