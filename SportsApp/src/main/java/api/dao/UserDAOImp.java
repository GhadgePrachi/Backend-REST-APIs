package api.dao;

import api.models.*;
import api.mappers.UserMapper;
import api.MyBatisConnectionFactory;
import api.utils.Constants;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserDAOImp implements UserDAO {

    private static final Logger log = LoggerFactory.getLogger(UserDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public UserDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public User createUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(user!=null){
                user.setStatus(Constants.STATUS_ACTIVE);
                UserMapper userMapper = session.getMapper(UserMapper.class);
                Integer result = userMapper.insertUser(user);
                UserNetwork network = userMapper.selectNetwork(user.getUserId());
                if(network==null){
                    network = new UserNetwork();//in case object is empty still create object with null set attributes
                }
                user.setNetwork(network);
                session.commit();
                if(result>0){
                    log.info("User created with id : " + user.getUserId());
                    return user;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public UserPreview validateUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        if(user!=null){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserPreview result = userMapper.selectUser(user);
            session.commit();

            if(result!=null){
                log.info("User exists with id : " + user.getUserId());
                return result;
            }

        }
        return null;

    }

    public User getUser(Integer userId) {
     SqlSession session = sqlSessionFactory.openSession();
        if(userId>0){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User result = userMapper.selectUserById(userId);
            UserNetwork network = userMapper.selectNetwork(userId);
            if(network==null){
                network = new UserNetwork();//in case object is empty still create object with null set attributes
            }
            result.setNetwork(network);
            session.commit();

            if(result!=null){
                log.info("User exists with id : " + userId);
                return result;
            }
        }
        return null;
    }

    public UserProfile getProfile(Integer userId){
        SqlSession session = sqlSessionFactory.openSession();
        if(userId>0){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            UserProfile result = userMapper.selectProfile(userId);
            UserNetwork network = userMapper.selectNetwork(userId);
            if(network==null){
                network = new UserNetwork();//in case object is empty still create object with null set attributes
            }
            result.setNetwork(network);
            session.commit();

            if(result!=null){
                log.info("User exists with id : " + userId);
                return result;
            }
        }
        return null;
    }

    public List<Event> getEvents(Integer userId, String selectedDate){
        SqlSession session = sqlSessionFactory.openSession();
        if(userId>0){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<Event> result = userMapper.selectEventsById(userId, selectedDate);
            session.commit();

            if(result!=null){
                log.info("User exists with id : " + userId);
                return result;
            }
        }
        return null;
    }

}
