package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.bean.VideoItemBean;
import me.fansir.rtvideo.constant.CommonRes;
import me.fansir.rtvideo.constant.IRequestMapping;
import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.service.RecordService;
import me.fansir.rtvideo.service.SubscribeService;
import me.fansir.rtvideo.service.VideoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class SubscribeController {

    Log logger = LogFactory.getLog(getClass());

    @Autowired
    VideoService videoService;

    @Autowired
    SubscribeService subscribeService;

    @Autowired
    RecordService recordService;

    @GetMapping(value = IRequestMapping.API_SUBSCRIBE_LIST)
    public String listSubscribe(@RequestParam(name = "uid") Long uid,
                                Model model) {

        List<VideoItemBean> videoItemBeanList = subscribeService
                .listSubscribePlayerId(uid, StateCode.NORMAL)
                .stream()
                .map(videoService::getLatestVideoByPlayerId)
                .map(videoService::transVideo2VideoListItem)
                .collect(Collectors.toList());
        model.addAttribute("mainHeader", "我的订阅");
        model.addAttribute("videoItemList", videoItemBeanList);
        return "videoList";
    }

    @PostMapping(value = IRequestMapping.API_SUBSCRIBE_ADD)
    @ResponseBody
    public CommonRes addSubscribe(Long viewerId, Long playerId) {
        Long subscribeId = subscribeService.addSubscribe(viewerId, playerId);
        logger.info("新增订阅, subscribeId=" + subscribeId);
        return CommonRes.retOk();
    }

    @PostMapping(value = IRequestMapping.API_SUBSCRIBE_DEL)
    @ResponseBody
    public CommonRes delSubscribe(Long viewerId, Long playerId) {

        subscribeService.deleteSubscribe(viewerId, playerId);
        return CommonRes.retOk();
    }

}
