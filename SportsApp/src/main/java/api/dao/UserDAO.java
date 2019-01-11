package api.dao;

import api.models.Event;
import api.models.UserProfile;
import api.models.User;
import api.models.UserPreview;

import java.util.List;

public interface UserDAO {
    User createUser(User u);
    UserPreview validateUser(User u);
    User getUser(Integer userId);
    UserProfile getProfile(Integer userId);
    List<Event> getEvents(Integer userId, String selectedDate);
}
