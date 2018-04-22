package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.bean.VideoItemBean;
import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.constant.CommonRes;
import me.fansir.rtvideo.constant.IRequestMapping;
import me.fansir.rtvideo.constant.ResultCode;
import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.model.Category;
import me.fansir.rtvideo.model.NginxRtmpParam;
import me.fansir.rtvideo.model.Room;
import me.fansir.rtvideo.model.Video;
import me.fansir.rtvideo.service.ConfigService;
import me.fansir.rtvideo.service.RoomService;
import me.fansir.rtvideo.service.UserService;
import me.fansir.rtvideo.service.VideoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class VideoController {

    Log logger = LogFactory.getLog(getClass());

    @Autowired
    VideoService videoService;

    @Autowired
    UserService userService;

    @Autowired
    ConfigService configService;

    @Autowired
    RoomService roomService;

    @PostMapping(value = IRequestMapping.API_VIDEO_ADD)
    @ResponseBody
    public CommonRes addVideo(NginxRtmpParam param) {
        Long playerId = roomService.getPlayerIdByRoomName(param.getName());
        Video latestVideo = videoService.getLatestVideoByPlayerId(playerId);
        if (latestVideo.getState() != StateCode.WAITING) {
            logger.debug("something wrong!");
            return CommonRes.ret(ResultCode.FAILURE, "请求异常");
        }
        videoService.updateVideoState(latestVideo.getId(), StateCode.NORMAL);
        return CommonRes.retOk();
    }

    @PostMapping(value = IRequestMapping.API_VIDEO_UPDATE)
    @ResponseBody
    public CommonRes updateVideo(Video video) {
        if (video.getId() == null) {
            return CommonRes.ret(ResultCode.FAILURE, "参数异常");
        }
        videoService.updateVideo(video);
        return CommonRes.retOk();
    }

    @PostMapping(value =IRequestMapping.API_PLAY_START)
    @ResponseBody
    public Room addVideoBaseInfo(Video video) {

        Room roomInfo = roomService.getRoom(video.getOwnerId());

        video.setState(StateCode.WAITING);
        video.setRtmpUrl(roomInfo.getRtmpUrl()+roomInfo.getName());
        videoService.addVideo(video);

        return roomInfo;
    }

    @PostMapping(value =IRequestMapping.API_PLAY_STOP)
    @ResponseBody
    public CommonRes stopVideoStream(NginxRtmpParam param) {
        if (param.getName() == null) {
            return CommonRes.ret(ResultCode.FAILURE, "参数异常");
        }
        Long playerId = roomService.getPlayerIdByRoomName(param.getName());

        Video latestVideo = videoService.getLatestVideoByPlayerId(playerId);
        latestVideo.setFlvUrl("");
        videoService.updateVideoLiveState(latestVideo.getId(), false);
        return CommonRes.retOk();
    }

    @GetMapping(value = IRequestMapping.API_VIDEO_ALL)
    public String allVideo(Model model) {
        VideoSearchBean searchBean = new VideoSearchBean();
        searchBean.setIslive(true);
        searchBean.setState(StateCode.NORMAL);

        List<VideoItemBean> videoItemBean = videoService.listVideoItemByParam(searchBean);

        model.addAttribute("mainHeader", "正在直播");
        model.addAttribute("videoItemList", videoItemBean);
        return "videoList";
    }

    @GetMapping(value = IRequestMapping.API_CATE_ALL)
    public String allCate(Model model) {
        List<Category> categoryList = configService.listAllCategory();
        model.addAttribute("mainHeader", "全部分类");
        model.addAttribute("catelist", categoryList);
        return "allcate";
    }

    @GetMapping(value = IRequestMapping.API_CATE_ALL+"/{id}")
    public String listVideoGroupByCate(@PathVariable(name = "id") Integer id, Model model) {
        String cateName = configService.getCategoryById(id).getName();
        VideoSearchBean searchBean = new VideoSearchBean();
        searchBean.setCateId(id);
        searchBean.setIslive(true);
        searchBean.setState(StateCode.NORMAL);

        List<VideoItemBean> videoItemBean = videoService.listVideoItemByParam(searchBean);

        model.addAttribute("mainHeader", "直播视频 | " + cateName);
        model.addAttribute("videoItemList", videoItemBean);
        return "videoList";
    }
}
