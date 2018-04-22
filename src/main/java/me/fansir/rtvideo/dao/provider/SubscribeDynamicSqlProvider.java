package me.fansir.rtvideo.dao.provider;

import me.fansir.rtvideo.constant.TableName;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class SubscribeDynamicSqlProvider {

    public String listSubscribePlayerId(@Param("viewerId") Long viewerId, @Param("state") Integer state) {
        String sql = new SQL() {
            {
                SELECT("owner_id");
                FROM(TableName.SUBSCRIBE);
                if (viewerId != null) {
                    WHERE("viewer_id=#{viewerId}");
                }
                if (state != null) {
                    AND();
                    WHERE("state=#{state}");
                }
            }
        }.toString();
        return sql;
    }
}
