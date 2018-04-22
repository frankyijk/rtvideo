package me.fansir.rtvideo.constant;

import lombok.Getter;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class CommonRes implements Serializable {

    @Getter
    private Integer code;
    @Getter
    private String  msg;

    public CommonRes(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonRes retOk() {
        return CommonRes.ret(ResultCode.SUCCESS, "success");
    }

    public static CommonRes ret(Integer code, String msg) {
        return new CommonRes(code, msg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommonRes{")
            .append("code=").append(code)
            .append(", msg=").append(msg)
            .append('}');
        return sb.toString();
    }
}
