package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.model.Room;
import me.fansir.rtvideo.service.ConfigService;
import me.fansir.rtvideo.service.RoomService;
import me.fansir.rtvideo.service.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class RoomServiceImpl implements RoomService {

    private final String ROOM_NAME_PRE = "238791";

    @Autowired
    ConfigService configService;

    @Autowired
    VideoService videoService;

    @Override
    public Room getRoom(Long uid) {
        List<String> rtmpUrlList = configService.listRtmpServerUrl();
        Random random = new Random(System.currentTimeMillis());
        int idx = random.nextInt(rtmpUrlList.size());
        Room room = new Room();
        room.setRtmpUrl(rtmpUrlList.get(idx));
        room.setName(ROOM_NAME_PRE + uid);
        return room;
    }

    public Long getPlayerIdByRoomName(String roomName) {
        return Long.parseLong(roomName.substring(ROOM_NAME_PRE.length()));
    }

    @Override
    public Integer getRoomNameByRtmpUrl(String rtmpUrl) {
        Integer res = null;
        String roomName = rtmpUrl.substring(rtmpUrl.lastIndexOf('/')+1);
        if (StringUtils.isNumeric(roomName)) {
            res = Integer.parseInt(roomName);
        }
        return res;
    }
}
