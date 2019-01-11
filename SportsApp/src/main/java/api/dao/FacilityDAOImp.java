package api.dao;

import api.MyBatisConnectionFactory;
import api.mappers.FacilityMapper;
import api.models.Facility;
import api.models.FacilityPreview;
import api.models.FacilityReview;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FacilityDAOImp {
    private static final Logger log = LoggerFactory.getLogger(FacilityDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public FacilityDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public List<FacilityPreview> getFacilities(String category, String location){
        SqlSession session = sqlSessionFactory.openSession();
        if(location!=null){
            FacilityMapper facilityMapper = session.getMapper(FacilityMapper.class);

            List<FacilityPreview> result = facilityMapper.selectFacilities(category,location);
            session.commit();

            if(result!=null){
                log.info("Facilities exists within location : " + location);
                return result;
            }
        }
        return null;
    }

    public Facility getFacilityDetails(Integer facilityId){
        SqlSession session = sqlSessionFactory.openSession();
        if(facilityId>0){
            FacilityMapper facilityMapper = session.getMapper(FacilityMapper.class);

            Facility result = facilityMapper.selectFacilityDetails(facilityId);
            session.commit();

            if(result!=null){
                log.info("Facility exists with id : " + facilityId);
                return result;
            }
        }
        return null;
    }

    public List<FacilityReview> getFacilityReviews(Integer facilityId){
        SqlSession session = sqlSessionFactory.openSession();
        if(facilityId>0){
            FacilityMapper facilityMapper = session.getMapper(FacilityMapper.class);

            List<FacilityReview> result = facilityMapper.selectFacilityReviews(facilityId);
            session.commit();

            if(result!=null){
                log.info("Facility exists with id : " + facilityId);
                return result;
            }
        }
        return null;
    }

}
