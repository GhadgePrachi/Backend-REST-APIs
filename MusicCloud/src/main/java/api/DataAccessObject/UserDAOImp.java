package api.DataAccessObject;

import api.EntityModel.User;
import api.Mappers.UserMapper;
import api.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOImp implements UserDAO {
    private static final Logger log = LoggerFactory.getLogger(UserDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;
    private final static int ACTIVE = 1;

    public UserDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public User createUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(user!=null){
                user.setStatus(ACTIVE);

                UserMapper userMapper = session.getMapper(UserMapper.class);
                int result = userMapper.insertUser(user);
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
}
