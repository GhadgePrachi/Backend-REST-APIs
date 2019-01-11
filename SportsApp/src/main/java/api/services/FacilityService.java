package api.services;

import api.models.Facility;
import api.models.FacilityPreview;
import api.models.FacilityReview;

import java.util.List;

public interface FacilityService {
    public List<FacilityPreview> getFacilities(String category, String location);
    public Facility getFacilityDetails(Integer facilityId);
    public List<FacilityReview> getFacilityReviews(Integer facilityId);
}
