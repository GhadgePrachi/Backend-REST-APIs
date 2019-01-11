package api.mappers.provider;

import api.utils.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class FacilityProvider {
    public String buildSelectFacilitiesQueryByCategoryLocationQuery(Map<String, Object> map){
        final String category = (String)map.get("category");
        final String location = (String)map.get("location");

        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.FACILITIES_TABLE);
            WHERE("address=#{location}");
            if(category!=null && category.length()>0){
                WHERE("category=#{category}");
            }
            }}.toString();
    }

    public String buildSelectFacilityDetailsByIdQuery(Map<String, Object> map){
        final Integer facilityId = (Integer)map.get("facilityId");
        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.FACILITIES_TABLE);
            WHERE("facility_id=#{facilityId}");
        }}.toString();
    }

    public String buildSelectFacilityReviewsByIdQuery(Map<String, Object> map){
        final Integer facilityId = (Integer)map.get("facilityId");
        return new SQL(){{
            SELECT(Constants.ALL_COLUMNS);
            FROM(Constants.REVIEWS_TABLE );
            JOIN(Constants.USERS_TABLE);
            WHERE("users.user_id = reviews.user_id AND facility_id=#{facilityId}");
            ORDER_BY(Constants.REVIEW_TIMING_COLUMN);
        }}.toString();
    }
}
