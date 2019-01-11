package api.dao;

import api.models.Court;
import api.models.CourtSlot;
import api.models.CourtReservation;

import java.util.List;

public interface CourtDAO {
    public List<CourtSlot> getReservedCourts(Integer facilityId, String startDate, String endDate);
    public List<Court> getAllCourts(Integer facilityId);
    public CourtReservation reserveCourt(Court court);

}
