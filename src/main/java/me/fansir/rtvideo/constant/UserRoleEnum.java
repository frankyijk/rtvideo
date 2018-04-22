package me.fansir.rtvideo.constant;

import lombok.Getter;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public enum UserRoleEnum {
    ROLE_VIEWER(1),
    ROLE_UPLOADER(2),
    ROLE_ADMIN(3);

    @Getter
    private int id;

    UserRoleEnum(int id) {
        this.id = id;
    }
}
