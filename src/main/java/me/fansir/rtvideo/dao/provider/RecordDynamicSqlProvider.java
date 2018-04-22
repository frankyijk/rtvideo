package me.fansir.rtvideo.dao.provider;

import me.fansir.rtvideo.constant.TableName;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class RecordDynamicSqlProvider {

    public String listRecordVideoIdWithParam(@Param("uid") Long uid, @Param("state") Integer state) {
        String sql = new SQL() {
            {
                SELECT("video_id");
                FROM(TableName.RECORD);
                if (uid != null) {
                    WHERE("user_id=#{uid}");
                }
                if (state != null) {
                    AND();
                    WHERE("state=#{state}");
                }
                ORDER_BY("gmt_modified");
            }
        }.toString();
        return sql + " desc";
    }
}
