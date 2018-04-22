package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.dao.provider.VideoDynamicSqlProvider;
import me.fansir.rtvideo.model.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface VideoDao {

    @Insert("insert into video(name, rtmp_url, category_id, owner_id, islive, state, gmt_create, gmt_modified) " +
            "values(#{name} ,#{rtmpUrl}, #{categoryId}, #{ownerId}, #{islive}, #{state}, sysdate(), sysdate())")
    @Options(useGeneratedKeys = true)
    void addVideo(Video video);

    @UpdateProvider(type = VideoDynamicSqlProvider.class, method = "updateVideo")
    void updateVideo(Video video);

    @Select("select * from video where id=#{videoId}")
    Video getVideoById(@Param("videoId") Long videoId);

    @SelectProvider(type = VideoDynamicSqlProvider.class, method = "listVideoByParam")
    List<Video> listVideoByParam(VideoSearchBean searchBean);

    @Select({"<script>" +
            "select * from video where id in " +
            "<foreach item='id' index='index' collection='videoIdList' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>"})
    List<Video> listVideoByVideoIds(@Param("videoIdList") List<Long> videoIdList);

    @Select("select * from video where owner_id=#{playerId} order by gmt_create desc limit 1")
    Video getLatestVideoByPlayerId(@Param("playerId") Long playerId);

    @Update("update video set ${pvOruv}=${pvOruv}+1 where id=#{videoId}")
    void increaseVideoPVOrPV(@Param("videoId") Long videoId, @Param("pvOruv") String pvOrUv);

}
