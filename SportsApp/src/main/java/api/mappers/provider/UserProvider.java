package api.mappers.provider;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;
import api.utils.Constants;

public class UserProvider {

    public String buildCreateUserQuery(){
        return new SQL() {{
            INSERT_INTO(Constants.USERS_TABLE);
            VALUES(Constants.USER_NAME_COLUMN, "#{userName}");
            VALUES(Constants.USER_EMAIL_COLUMN, "#{emailId}");
            VALUES(Constants.USER_PASSWORD_COLUMN, "#{password}");
            VALUES(Constants.USER_LOCATION_COLUMN, "#{location}");
            VALUES(Constants.USER_STATUS, "#{status}");
        }}.toString();
    }

    public String buildSelectUserQueryByEmailAndPassword(){
        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.USERS_TABLE);
            WHERE("email=#{emailId} AND password=#{password}");
        }}.toString();
    }

    public String buildSelectUserByIdQuery(Map<String, Object> map){
        final Integer userId = (Integer)map.get("userId");
        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.USERS_TABLE);
            WHERE("user_id=#{userId}");
        }}.toString();
    }

    public String buildSelectEventsByIdQuery(Map<String, Object> map){
        final Integer userId = (Integer)map.get("userId");
        final String selectedDate = (String)map.get("selectedDate");

        return new SQL(){{
            SET("time_zone = '+05:30'");
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.COURT_RESERVATION_TABLE);
            INNER_JOIN(Constants.COURTS_TABLE);
            WHERE("courts.court_id = court_reservation.court_id");
            INNER_JOIN(Constants.FACILITIES_TABLE);
            WHERE("courts.facility_id = facilities.facility_id");
            WHERE("user_id=#{userId}");
            if(selectedDate!=null && selectedDate.length()>0) {
                WHERE("date_format(convert_tz(from_unixtime(start_time),'+00:00','+05:30'),'%m/%d/%Y')  = #{selectedDate}");
            }
        }}.toString();
    }
}
