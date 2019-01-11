package api.services;

import api.dao.FacilityDAOImp;
import api.models.Facility;
import api.models.FacilityPreview;
import api.models.FacilityReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FacilityServiceImp {
    private static final Logger log = LoggerFactory.getLogger(FacilityService.class);
    FacilityDAOImp facilityDAO = null;
    public FacilityServiceImp(){
        facilityDAO = new FacilityDAOImp();
    }

    public List<FacilityPreview> getFacilities(String category, String location){
        if(location!=null){
            return facilityDAO.getFacilities(category,location);
        }
        return null;
    }

    public Facility getFacilityDetails(Integer facilityId){
        if(facilityId>0){
            return facilityDAO.getFacilityDetails(facilityId);
        }
        return null;
    }

    public List<FacilityReview> getFacilityReviews(Integer facilityId){
        if(facilityId>0){
            return facilityDAO.getFacilityReviews(facilityId);
        }
        return null;
    }

}
