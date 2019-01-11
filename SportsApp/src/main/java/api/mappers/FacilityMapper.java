package api.mappers;

import api.mappers.provider.FacilityProvider;
import api.models.Facility;
import api.models.FacilityPreview;
import api.models.FacilityReview;
import api.utils.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface FacilityMapper {
    //Select Facilities With Category, location and date
    @SelectProvider(type = FacilityProvider.class, method = "buildSelectFacilitiesQueryByCategoryLocationQuery")
    @Results({
            @Result(column = Constants.FACILITY_ID_COLUMN, property = "facilityId"),
            @Result(column = Constants.FACILITY_NAME_COLUMN, property = "facilityName"),
            @Result(column = Constants.FACILITY_ADDRESS_COLUMN, property = "address"),
            @Result(column = Constants.FACILITY_TELEPHONE_COLUMN, property = "telephone"),
            @Result(column = Constants.FACILITY_TIMINGS_COLUMN, property = "timings"),
            @Result(column = Constants.FACILITY_RATINGS_COLUMN, property = "ratings")
    })
    List<FacilityPreview> selectFacilities(@Param("category") String category, @Param("location") String location);

    //Select FacilityDetails By Id
    @SelectProvider(type = FacilityProvider.class, method = "buildSelectFacilityDetailsByIdQuery")
    @Results({
            @Result(column = Constants.FACILITY_ID_COLUMN, property = "facilityId"),
            @Result(column = Constants.FACILITY_NAME_COLUMN, property = "facilityName"),
            @Result(column = Constants.FACILITY_CATEGORY_COLUMN, property = "category"),
            @Result(column = Constants.FACILITY_ADDRESS_COLUMN, property = "address"),
            @Result(column = Constants.FACILITY_TELEPHONE_COLUMN, property = "telephone"),
            @Result(column = Constants.FACILITY_TIMINGS_COLUMN, property = "timings"),
            @Result(column = Constants.FACILITY_RATINGS_COLUMN, property = "ratings"),
            @Result(column = Constants.FACILITY_SUMMARY_COLUMN, property = "summary"),
            @Result(column = Constants.FACILITY_IMAGE_URL_COLUMN, property = "imageUrl")

            })
    Facility selectFacilityDetails(@Param("facilityId")Integer facilityId);

    //Select FacilityReviews By Id
    @SelectProvider(type = FacilityProvider.class, method = "buildSelectFacilityReviewsByIdQuery")
    @Results({
            @Result(column = Constants.REVIEW_ID_COLUMN, property = "reviewId"),
            @Result(column = Constants.USER_NAME_COLUMN, property = "userName"),
            @Result(column = Constants.REVIEW_CONTENT_COLUMN, property = "content"),
            @Result(column = Constants.REVIEW_TIMING_COLUMN, property = "time")
    })
    List<FacilityReview> selectFacilityReviews(@Param("facilityId")Integer facilityId);

}
