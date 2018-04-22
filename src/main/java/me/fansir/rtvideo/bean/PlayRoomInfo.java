package me.fansir.rtvideo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: fanlinyu
 * @Date: 1/17/18
 */
@Data
public class PlayRoomInfo implements Serializable {
    private Long    playerId;
    private String  nickname;
    private String  avatar;

    private Integer roomName;

    private Long    videoId;
    private String  videoname;
    private Boolean islive;
    // 直播
    private String  rtmpUrl;
    private String  dashUrl;
    private String  flvHttpUrl;
    // 点播
    private String  flvUrl;

    private Integer followerNum;
    private Boolean subscribed;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayRoomInfo{")
            .append("playerId=").append(playerId)
            .append(", nickname=").append(nickname)
            .append(", avatar=").append(avatar)
            .append(", roomName=").append(roomName)
            .append(", videoId=").append(videoId)
            .append(", videoname=").append(videoname)
            .append(", islive=").append(islive)
            .append(", rtmpUrl=").append(rtmpUrl)
            .append(", dashUrl=").append(dashUrl)
            .append(", flvHttpUrl=").append(flvHttpUrl)
            .append(", flvUrl=").append(flvUrl)
            .append(", followerNum=").append(followerNum)
            .append(", subscribed=").append(subscribed)
            .append('}');
        return sb.toString();
    }
}
