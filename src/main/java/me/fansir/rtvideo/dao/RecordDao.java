package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.dao.provider.RecordDynamicSqlProvider;
import me.fansir.rtvideo.model.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface RecordDao {

    @SelectProvider(type = RecordDynamicSqlProvider.class, method = "listRecordVideoIdWithParam")
    List<Long> listRecordVideoId(@Param("uid") Long uid, @Param("state") Integer state);

    @Insert("insert record(user_id, video_id, state, gmt_create, gmt_modified) " +
            "values(#{userId}, #{videoId}, #{state}, sysdate(), sysdate())")
    @Options(useGeneratedKeys = true)
    void addWatchRecord(Record record);

    @Update("update record set gmt_modified=sysdate(),state=#{state} where id=#{recordId}")
    void updateRecordState(@Param("recordId") Long recordId, @Param("state") Integer state);

    @Update("update record set gmt_modified=sysdate(),state=#{state} where user_id=#{uid} and state=0")
    void updateCertainUserRecordState(@Param("uid") Long uid, @Param("state") Integer state);

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "video_id", property = "videoId"),
            @Result(column = "state", property = "state"),
            @Result(column = "gmt_create", property = "gmt_create"),
            @Result(column = "gmt_modified", property = "gmt_modified")
    })
    @Select("select * from record where user_id=#{userId} and video_id=#{videoId} order by gmt_modified desc")
    Record getRecordByUserIdAndVideoId(@Param("userId") Long userId, @Param("videoId") Long videoId);

    @Update("update record set gmt_modified=sysdate(),state=2 where user_id=#{userId} and video_id=#{videoId}")
    void deleteRecord(@Param("userId") Long viewerId, @Param("videoId") Long videoId);
}
