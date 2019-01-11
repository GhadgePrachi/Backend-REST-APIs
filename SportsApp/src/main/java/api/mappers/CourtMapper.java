package api.mappers;

import api.mappers.provider.CourtProvider;
import api.models.Court;
import api.models.CourtSlot;
import api.models.CourtReservation;
import api.utils.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourtMapper {
    //Select Courts By facilityId, start and end date
    @SelectProvider(type = CourtProvider.class, method = "buildSelectCourtsByStartDateEndDateQuery")
    @Results({
            @Result(column = Constants.COURT_ID_COLUMN, property = "courtId"),
            @Result(column = Constants.COURT_NAME_COLUMN, property = "courtName"),
            @Result(column = Constants.COURT_RESERVATION_DESCRIPTION_COLUMN, property = "description"),
            @Result(column = Constants.COURT_RESERVATION_START_TIME_COLUMN, property = "startTime"),
            @Result(column = Constants.COURT_RESERVATION_END_TIME_COLUMN, property = "endTime"),
            @Result(column = Constants.COURT_RESERVATION_PRICE_COLUMN, property = "price")
    })
    List<CourtSlot> selectReservedCourts(@Param("facilityId")Integer facilityId, @Param("startDate")String startDate, @Param("endDate")String endDate);

    //Select All Courts By facilityId
    @SelectProvider(type = CourtProvider.class, method = "buildSelectAllCourtsQuery")
    @Results({
            @Result(column = Constants.COURT_ID_COLUMN, property = "courtId"),
            @Result(column = Constants.COURT_NAME_COLUMN, property = "courtName"),
            @Result(column = Constants.COURT_HOURLY_PRICE_COLUMN, property = "price"),
    })
    List<Court> selectAllCourts(@Param("facilityId")Integer facilityId);

    //Insert Court Reserved
    @InsertProvider(type = CourtProvider.class, method = "buildReserveCourtQuery")
    @Options(useGeneratedKeys = true, keyProperty = "reservation_id")
    Integer insertCourtReservation(CourtReservation courtReservation);

}
