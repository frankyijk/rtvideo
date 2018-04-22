package me.fansir.rtvideo.service;

import me.fansir.rtvideo.bean.PlayRoomInfo;
import me.fansir.rtvideo.bean.VideoItemBean;
import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.model.Video;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public interface VideoService {
    /**
     * video 表新增直播视频信息
     *
     * @param video
     * @return id of {@link Video}
     */
    Long addVideo(Video video);

    /**
     * 更新视频
     *
     * @param video
     */
    void updateVideo(Video video);

    /**
     * 跟新视频状态
     *
     * @param videoId
     * @param state
     */
    void updateVideoState(Long videoId, Integer state);

    /**
     * 跟新视频直播状态
     *
     * @param videoId
     * @param islive
     */
    void updateVideoLiveState(Long videoId, Boolean islive);

    /**
     * 删除指定视频（更新对应 video#state 为 DELETE）
     *
     * @param videoId
     */
    void deleteVideo(Long videoId);

    /**
     * 返回指定视频的详细信息
     *
     * @param videoId
     * @return  Object of {@link Video}
     */
    Video getVideoById(Long videoId);

    /**
     * 根据条件返回 video 列表
     *
     * @param searchBean
     * @return list of {@link Video}
     */
    List<Video> listVideoByParam(VideoSearchBean searchBean);

    /**
     * 根据条件返回 video 列表
     *
     * @param searchBean
     * @return list of {@link VideoItemBean}
     */
    List<VideoItemBean> listVideoItemByParam(VideoSearchBean searchBean);

    /**
     * 获取指定视频列表
     *
     * @param videoIds
     * @return list of {@link Video}
     */
    List<Video> listVideoByVideoIds(List<Long> videoIds);

    /**
     * 将 Video 类型数据转为 VideoItemBean 类型
     *
     * @param video
     * @return {@link VideoItemBean}
     */
    VideoItemBean transVideo2VideoListItem(Video video);

    /**
     * 获取视频播放页面信息
     *
     * @param videoId
     * @return {@link PlayRoomInfo}
     */
    PlayRoomInfo getPlayRoomInfoByVideoId(Long videoId);

    /**
     * 返回指定主播的最新视频
     *
     * @param playerId
     * @return
     */
    Video getLatestVideoByPlayerId(Long playerId);

    void increaseVideoPV(Long videoId);

    void increaseVideoUV(Long videoId);
}
