package api.mappers.provider;

import api.utils.Constants;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

public class SettingProvider {

    public String buildGeneralSettingQuery(Map<String, Object> map){
        final Integer userId = (Integer)map.get("userId");

        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.USERS_TABLE);
            WHERE("user_id = #{userId}");

        }}.toString();
    }

    public String buildAdvancedSettingQuery(Map<String, Object> map){
        final Integer userId = (Integer)map.get("userId");

        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.SETTINGS_TABLE);
            WHERE("user_id = #{userId}");

        }}.toString();
    }
}
