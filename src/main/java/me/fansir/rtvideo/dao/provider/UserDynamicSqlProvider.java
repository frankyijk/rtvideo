package me.fansir.rtvideo.dao.provider;

import me.fansir.rtvideo.constant.TableName;
import me.fansir.rtvideo.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
public class UserDynamicSqlProvider {

    public String updateUser(User user) {
        String sql = new SQL() {
            {
                UPDATE(TableName.USER);
                SET("gmt_modified = sysdate()");
                if (StringUtils.isNotBlank(user.getNickname())) {
                    SET("nickname = #{nickname}");
                }
                if (user.getGender() != null) {
                    SET("gender = #{gender}");
                }
                if (StringUtils.isNotBlank(user.getPassword())) {
                    SET("password = #{password}");
                }
                if (StringUtils.isNotBlank(user.getAvatar())) {
                    SET("avatar = #{avatar}");
                }
                if (StringUtils.isNotBlank(user.getPhone())) {
                    SET("phone = #{phone}");
                }
                if (user.getLocked() != null) {
                    SET("locked = #{locked}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
        return sql;
    }
}
