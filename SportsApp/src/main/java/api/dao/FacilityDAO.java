package api.dao;

import api.models.Facility;
import api.models.FacilityReview;

import java.util.List;

public interface FacilityDAO {
    public List<Facility> getCourts(String category, String location);
    public Facility getFacilityDetails(Integer facilityId);
    public List<FacilityReview> getFacilityReviews(Integer facilityId);
}
