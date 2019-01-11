package api.dao;

import api.MyBatisConnectionFactory;
import api.mappers.CourtMapper;
import api.models.Court;
import api.models.CourtSlot;
import api.models.CourtReservation;
import api.utils.Constants;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourtDAOImp {

    private static final Logger log = LoggerFactory.getLogger(CourtDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public CourtDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public List<CourtSlot> getReservedCourts(Integer facilityId, String startDate, String endDate){
        SqlSession session = sqlSessionFactory.openSession();
        if(facilityId>0){
            CourtMapper courtMapper = session.getMapper(CourtMapper.class);

            List<CourtSlot> result = courtMapper.selectReservedCourts(facilityId,startDate,endDate);
            session.commit();

            if(result!=null){
                log.info("Courts exists with facilityId : " + facilityId);
                return result;
            }
        }
        return null;
    }

    public List<Court> getAllCourts(Integer facilityId) {
        SqlSession session = sqlSessionFactory.openSession();

        CourtMapper courtMapper = session.getMapper(CourtMapper.class);
        List<Court> result = courtMapper.selectAllCourts(facilityId);
        session.commit();

        if (result != null) {
            log.info("Courts exists with facility id :  " + facilityId);
            return result;
        }
        return null;
    }

    public CourtReservation reserveCourt(CourtReservation courtReservation){
        SqlSession session = sqlSessionFactory.openSession();
        if(courtReservation!=null){
            CourtMapper courtMapper = session.getMapper(CourtMapper.class);
            courtReservation.setStatus(Constants.STATUS_ACTIVE);
            Integer result = courtMapper.insertCourtReservation(courtReservation);
            session.commit();

            if(result>0){
                log.info("Court reservation made with reservation id : " + result);
                return courtReservation;
            }
        }
        return null;
    }
}
