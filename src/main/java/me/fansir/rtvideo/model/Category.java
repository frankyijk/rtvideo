package me.fansir.rtvideo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class Category implements Serializable {

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer pid;    // 父类 ID
    @Getter
    @Setter
    private String  name;
    @Getter
    @Setter
    private String  img;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category{")
            .append("id=").append(id)
            .append(", pid=").append(pid)
            .append(", name=").append(name)
            .append(", img=").append(img)
            .append('}');
        return sb.toString();
    }
}
