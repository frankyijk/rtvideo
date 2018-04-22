package me.fansir.rtvideo.dao.provider;

import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.constant.TableName;
import me.fansir.rtvideo.model.Video;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class VideoDynamicSqlProvider {

    public String updateVideo(Video video) {
        String sql = new SQL() {
            {
                UPDATE(TableName.VIDEO);
                SET("gmt_modified = sysdate()");
                if (video.getIslive() != null) {
                    SET("islive = #{islive}");
                }
                if (video.getState() != null) {
                    SET("state = #{state}");
                }
                if (StringUtils.isNotBlank(video.getFlvUrl())) {
                    SET("flv_url = #{flvUrl}");
                }
                if (StringUtils.isNotBlank(video.getThumbnail())) {
                    SET("vthumb = #{thumbnail}");
                }
                if (video.getUv() != null) {
                    SET("uv = #{uv}");
                }
                if (video.getPv() != null) {
                    SET("pv = #{pv}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
        return sql;
    }

    public String listVideoByParam(VideoSearchBean searchBean) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(TableName.VIDEO);
                if (searchBean.getVideoId() != null) {
                    AND();
                    WHERE("id=#{videoId}");
                }
                if (searchBean.getOwnerId() != null) {
                    WHERE("owner_id=#{ownerId}");
                }
                if (searchBean.getIslive() != null) {
                    AND();
                    WHERE("islive=#{islive}");
                }
                if (searchBean.getState() != null) {
                    AND();
                    WHERE("state=#{state}");
                }
                if (searchBean.getCateId() != null) {
                    AND();
                    WHERE("category_id = #{cateId}");
                }
                if (searchBean.getLtime() != null) {
                    AND();
                    WHERE("gmt_create > #{ltime}");
                }
                if (searchBean.getRtime() != null) {
                    AND();
                    WHERE("gmt_create < #{rtime}");
                }
                ORDER_BY("gmt_create");
            }
        }.toString();
        return sql + " desc";
    }
}
