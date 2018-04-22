package me.fansir.rtvideo.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class Role implements Serializable {

    public Role() {}
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String  name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Role{")
            .append("id=").append(id)
            .append(", name=").append(name)
            .append('}');
        return sb.toString();
    }
}
