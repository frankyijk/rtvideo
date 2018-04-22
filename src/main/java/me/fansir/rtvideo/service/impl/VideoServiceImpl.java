package me.fansir.rtvideo.service.impl;

import me.fansir.rtvideo.bean.PlayRoomInfo;
import me.fansir.rtvideo.bean.VideoItemBean;
import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.dao.VideoDao;
import me.fansir.rtvideo.model.Subscribe;
import me.fansir.rtvideo.model.User;
import me.fansir.rtvideo.model.Video;
import me.fansir.rtvideo.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Service
public class VideoServiceImpl implements VideoService {

    Log logger = LogFactory.getLog(getClass());

    @Autowired
    VideoDao videoDao;

    @Autowired
    UserService userService;

    @Autowired
    ConfigService configService;

    @Autowired
    SubscribeService subscribeService;

    @Autowired
    RoomService roomService;

    @Override
    public Long addVideo(Video video) {
        if (video.getIslive() == null) {
            video.setIslive(true);
        }
        if (video.getState() == null) {
            video.setState(StateCode.NORMAL);
        }
        videoDao.addVideo(video);
        logger.info("add video success, videoId=" + video.getId());
        return video.getId();
    }

    @Override
    public void updateVideo(Video video) {
        if (video == null || video.getId() == null) {
            return;
        }
        videoDao.updateVideo(video);
    }

    @Override
    public void updateVideoState(Long videoId, Integer state) {
        Video video = new Video();
        video.setId(videoId);
        video.setState(state);
        videoDao.updateVideo(video);
    }

    @Override
    public void updateVideoLiveState(Long videoId, Boolean islive) {
        Video video = new Video();
        video.setId(videoId);
        video.setIslive(islive);
        videoDao.updateVideo(video);
    }

    @Override
    public void deleteVideo(Long videoId) {
        Video video = new Video();
        video.setId(videoId);
        video.setState(StateCode.DELETE);
        videoDao.updateVideo(video);
    }

    @Override
    public Video getVideoById(Long videoId) {
        return videoDao.getVideoById(videoId);
    }

    @Override
    public List<Video> listVideoByParam(VideoSearchBean searchBean) {
        return videoDao.listVideoByParam(searchBean);
    }

    @Override
    public List<VideoItemBean> listVideoItemByParam(VideoSearchBean searchBean) {
        List<VideoItemBean> videoItemBeanList = null;
        List<Video> videoList = listVideoByParam(searchBean);
        if (videoList != null && !videoList.isEmpty()) {
            videoItemBeanList = videoList.stream().map(this::transVideo2VideoListItem).collect(Collectors.toList());
        }
        return videoItemBeanList;
    }

    @Override
    public List<Video> listVideoByVideoIds(List<Long> videoIds) {
        return videoDao.listVideoByVideoIds(videoIds);
    }

    @Override
    public VideoItemBean transVideo2VideoListItem(Video video) {
        if (video.getCategoryId() == null || video.getOwnerId() == null) {
            logger.error("param error! param=" + video);
            return null;
        }

        VideoItemBean itemBean = new VideoItemBean();
        BeanUtils.copyProperties(video, itemBean);
        itemBean.setVideoId(video.getId());
        itemBean.setVideoName(video.getName());
        itemBean.setOwnerNickname(userService.getUserById(video.getOwnerId()).getNickname());
        itemBean.setCategoryName(configService.getCategoryById(video.getCategoryId()).getName());
        itemBean.setRoomName(roomService.getRoomNameByRtmpUrl(video.getRtmpUrl()));
        return itemBean;
    }

    @Override
    public PlayRoomInfo getPlayRoomInfoByVideoId(Long videoId) {
        PlayRoomInfo playRoomInfo = new PlayRoomInfo();

        Video video = this.getVideoById(videoId);
        Integer roomName = roomService.getRoomNameByRtmpUrl(video.getRtmpUrl());

        playRoomInfo.setVideoId(videoId);
        playRoomInfo.setVideoname(video.getName());
        playRoomInfo.setIslive(video.getIslive());
        if (!video.getIslive()) {   // 点播视频
            playRoomInfo.setFlvUrl(video.getFlvUrl());
        } else {
            playRoomInfo.setRtmpUrl(video.getRtmpUrl());
            if (roomName != null) {
                playRoomInfo.setDashUrl(configService.getDashServerUrl() + roomName + ".mpd");
                playRoomInfo.setFlvHttpUrl(configService.getFlvOverHttpUrl() + roomName + ".flv");
                playRoomInfo.setRoomName(roomName);
            }
        }

        User player = userService.getUserById(video.getOwnerId());
        playRoomInfo.setPlayerId(player.getId());
        playRoomInfo.setAvatar(player.getAvatar());
        playRoomInfo.setNickname(player.getNickname());

        playRoomInfo.setFollowerNum(subscribeService.countFollowerNum(player.getId()));
        return playRoomInfo;
    }

    @Override
    public Video getLatestVideoByPlayerId(Long playerId) {
        return videoDao.getLatestVideoByPlayerId(playerId);
    }

    @Override
    public void increaseVideoPV(Long videoId) {
        videoDao.increaseVideoPVOrPV(videoId, "pv");
    }

    @Override
    public void increaseVideoUV(Long videoId) {
        videoDao.increaseVideoPVOrPV(videoId, "uv");
    }

}
