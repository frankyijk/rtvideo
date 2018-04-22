package me.fansir.rtvideo.dao;

import me.fansir.rtvideo.dao.provider.SubscribeDynamicSqlProvider;
import me.fansir.rtvideo.model.Subscribe;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Mapper
public interface SubscribeDao {

    @SelectProvider(type = SubscribeDynamicSqlProvider.class, method = "listSubscribePlayerId")
    List<Long> listSubscribePlayerId(@Param("viewerId") Long viewerId, @Param("state") Integer state);

    @Insert("insert into subscribe(viewer_id, owner_id, state, gmt_create, gmt_modified)" +
            " values(#{viewerId}, #{ownerId}, 0, sysdate(), sysdate())")
    @Options(useGeneratedKeys = true)
    void addSubscribe(Subscribe subscribe);

    @Update("update subscribe set state=#{state} where viewer_id=#{viewerId} and owner_id=#{playerId}")
    void updateSubscribeState(@Param("viewerId") Long viewerId, @Param("playerId") Long playerId, @Param("state") Integer state);

    @Select("select count(*) from subscribe where owner_id=#{ownerId} and state=0")
    Integer countFollowerNum(@Param("ownerId") Long playerId);

    @Select("select * from subscribe where viewer_id=#{viewerId} and owner_id=#{playerId}")
    Subscribe getSubscribe(@Param("viewerId") Long viewerId, @Param("playerId") Long playerId);
}
