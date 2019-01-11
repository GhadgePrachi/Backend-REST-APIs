package api.mappers.provider;

import api.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CourtProvider {
    public String buildSelectCourtsByStartDateEndDateQuery(Map<String, Object> map) {
        final Integer facilityId = (Integer) map.get("facilityId");
        final String startDate = (String) map.get("startDate");
        final String endDate = (String) map.get("endDate");

        return new SQL() {{
            SET("time_zone = '+05:30'");
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.COURTS_TABLE);
            JOIN(Constants.COURT_RESERVATION_TABLE);
            WHERE("courts.court_id = court_reservation.court_id");
            WHERE("facility_id=#{facilityId}");
            if (startDate != null && startDate.length() > 0) {
                WHERE("from_unixtime(start_time, '%m/%d/%Y') >= #{startDate}");
            }
            if (endDate != null && endDate.length() > 0) {
                WHERE("from_unixtime(end_time, '%m/%d/%Y') <= #{endDate}");
            }
        }}.toString();
    }

    public String buildSelectAllCourtsQuery(Map<String, Object> map) {
        final Integer facilityId = (Integer) map.get("facilityId");

        return new SQL() {{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.COURTS_TABLE);
            WHERE("facility_id=#{facilityId}");
        }}.toString();
    }

    public String buildReserveCourtQuery() {
        return new SQL() {{
            INSERT_INTO(Constants.COURT_RESERVATION_TABLE);
            VALUES(Constants.COURT_ID_COLUMN, "#{courtId}");
            VALUES(Constants.USER_ID_COLUMN, "#{userId}");
            VALUES(Constants.COURT_RESERVATION_DESCRIPTION_COLUMN, "#{description}");
            VALUES(Constants.COURT_RESERVATION_START_TIME_COLUMN, "#{startTime}");
            VALUES(Constants.COURT_RESERVATION_END_TIME_COLUMN, "#{endTime}");
            VALUES(Constants.COURT_RESERVATION_PRICE_COLUMN, "#{price}");
        }}.toString();
    }

}
