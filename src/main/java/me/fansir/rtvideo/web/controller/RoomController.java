package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.bean.PlayRoomInfo;
import me.fansir.rtvideo.constant.IRequestMapping;
import me.fansir.rtvideo.model.Category;
import me.fansir.rtvideo.service.ConfigService;
import me.fansir.rtvideo.service.RecordService;
import me.fansir.rtvideo.service.SubscribeService;
import me.fansir.rtvideo.service.VideoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class RoomController {

    Log logger = LogFactory.getLog(getClass());

    @Autowired
    ConfigService configService;

    @Autowired
    VideoService videoService;

    @Autowired
    RecordService recordService;

    @Autowired
    SubscribeService subscribeService;

    @GetMapping(value = IRequestMapping.API_ROOM_SETTING)
    public String roomSetting(Model model) {
        List<Category> categoryList = configService.listAllCategory();
        model.addAttribute("catelist", categoryList);
        return "roomsetting";
    }

    @GetMapping(value = IRequestMapping.API_ROOM_PLAYER+"/{roomName}")
    public String roomPlayer(@RequestParam(name = "videoId") Long videoId,
                             @RequestParam(name = "viewerId") Long viewerId,
                             Model model) {

        PlayRoomInfo playRoomInfo = videoService.getPlayRoomInfoByVideoId(videoId);
        Boolean subscribed = subscribeService.alreadySubscribed(viewerId, playRoomInfo.getPlayerId());

        // 添加用户观看记录
        playRoomInfo.setSubscribed(subscribed);
        recordService.addWatchRecord(viewerId, videoId);

        // 更新视频点击数
        videoService.increaseVideoPV(videoId);

        model.addAttribute("playRoomInfo", playRoomInfo);
        return "player";
    }
}
