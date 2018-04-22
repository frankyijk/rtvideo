package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.bean.VideoItemBean;
import me.fansir.rtvideo.constant.CommonRes;
import me.fansir.rtvideo.constant.IRequestMapping;
import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.service.RecordService;
import me.fansir.rtvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class RecordController {

    @Autowired
    RecordService recordService;

    @Autowired
    VideoService videoService;

    @PostMapping(value = IRequestMapping.API_HISTORY_DEL)
    @ResponseBody
    public CommonRes delRecord(Long viewerId, Long videoId) {
        recordService.deleteRecord(viewerId, videoId);
        return CommonRes.retOk();
    }

    @PostMapping(value = IRequestMapping.API_HISTORY_CLEAR)
    @ResponseBody
    public CommonRes clearRecord(Long uid) {
        recordService.deleteAllRecord(uid);
        return CommonRes.retOk();
    }

    @GetMapping(value = IRequestMapping.API_HISTORY_LIST)
    public String listWatchHistory(Long uid, Model model) {
        List<Long> videoIdList = recordService.listRecordVideoId(uid, StateCode.NORMAL);

        List<VideoItemBean> videoItemBean = null;
        if (videoIdList != null && !videoIdList.isEmpty()) {
            videoItemBean = videoService.listVideoByVideoIds(videoIdList).stream()
                    .map(videoService::transVideo2VideoListItem).collect(Collectors.toList());
        }
        model.addAttribute("mainHeader", "观看记录");
        model.addAttribute("videoItemList", videoItemBean);
        return "videoList";
    }
}
