package me.fansir.rtvideo.constant;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class IRequestMapping {

    /**
     * 删除记录
     *
     * @param viewerId  Long
     * @param videoId   Long
     * @return  {@link CommonRes}
     */
    public static final String API_HISTORY_DEL = "/history/del";

    /**
     * 清空记录
     *
     * @param uid   Long
     * @return {@link CommonRes}
     */
    public static final String API_HISTORY_CLEAR = "/history/clear";

    /**
     * 我的订阅
     *
     * @param uid   Long
     * @return view
     */
    public static final String API_SUBSCRIBE_LIST = "/myfollow";

    /**
     * 添加订阅
     *
     * @param viewerId  Long
     * @param playerId  Long
     * @return {@link CommonRes}
     */
    public static final String API_SUBSCRIBE_ADD = "/myfollow/add";

    /**
     * 取消订阅
     *
     * @param viewerId  Long
     * @param playerId  Long
     * @return {@link CommonRes}
     */
    public static final String API_SUBSCRIBE_DEL = "/myfollow/del";

    /**
     * 直播设置
     *
     * @request
     * @return
     */
    public static final String API_ROOM_SETTING = "/roomsetting";

    /**
     * 视频播放
     *
     * @param videoId   Long
     * @param viewerId  Long
     * @return view
     */
    public static final String API_ROOM_PLAYER = "/room/";

    /**
     * 开始直播
     *
     * @param video {@link me.fansir.rtvideo.model.Video}
     * @return Object of {@link me.fansir.rtvideo.model.Room}
     */
    public static final String API_PLAY_START = "/video/start";

    /**
     * 结束直播
     *
     * @param param {@link me.fansir.rtvideo.model.NginxRtmpParam}
     * @return {@link CommonRes}
     */
    public static final String API_PLAY_STOP = "/video/stop";

    /**
     * 我要做主播
     *
     * @param uid   Long
     * @return {@link CommonRes}
     */
    public static final String API_VIEWER_APPLY = "/user/apply2player";

    /**
     * 添加视频
     *
     * @param param {@link me.fansir.rtvideo.model.NginxRtmpParam}
     * @return {@link CommonRes}
     */
    public static final String API_VIDEO_ADD = "/video/add";

    /**
     * 更新视频
     *
     * @param video {@link me.fansir.rtvideo.model.Video}
     * @return {@link CommonRes}
     */
    public static final String API_VIDEO_UPDATE = "/video/update";

    /**
     * 直播列表
     *
     * @request
     * @return  view
     */
    public static final String API_VIDEO_ALL = "/all";

    /**
     * 直播分类列表
     *
     * @request
     * @return
     */
    public static final String API_CATE_ALL = "/cate";

    /**
     * 观看记录
     *
     * @param uid   Long
     * @return view
     */
    public static final String API_HISTORY_LIST = "/watchhistory";

}
