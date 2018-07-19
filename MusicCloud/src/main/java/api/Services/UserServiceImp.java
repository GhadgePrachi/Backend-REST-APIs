package api.Services;

import api.DataAccessObject.UserDAOImp;
import api.EntityModel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImp implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    UserDAOImp userDAO = null;
    public UserServiceImp(){
        userDAO = new UserDAOImp();
    }

    @Override
    public User createUser(User user) {
        if(user!=null){
            return userDAO.createUser(user);
        }
        return null;
    }
}