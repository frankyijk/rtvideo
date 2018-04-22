package me.fansir.rtvideo.service;

import me.fansir.rtvideo.model.Room;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface RoomService {
    /**
     * 为主播生成直播房间，包括推流地址、流名称（房间号）
     *
     * @param uid
     * @return Object of {@link Room}
     */
    Room getRoom(Long uid);

    /**
     * 根据房间号获取主播 ID
     * @param roomName
     * @return
     */
    Long getPlayerIdByRoomName(String roomName);

    /**
     * 根据直播视频 RTMP 流地址获取直播房间
     *
     * @param rtmpUrl
     * @return
     */
    Integer getRoomNameByRtmpUrl(String rtmpUrl);
}
