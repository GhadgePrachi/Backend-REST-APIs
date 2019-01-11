package api.services;

import api.models.CourtSlot;
import api.models.CourtReservation;

import java.util.List;

public interface CourtService {
    public List<CourtSlot> getCourts(Integer facilityId, String startDate, String endDate);
    public CourtReservation reserveCourt(CourtReservation court);

}
