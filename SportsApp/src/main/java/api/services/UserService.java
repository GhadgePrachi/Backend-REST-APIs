package api.services;

import api.models.*;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public UserPreview validateUser(User user);
    public User getUser(Integer userId);
    public UserProfile getProfile(Integer userId);
    public List<EventsGroupedByDate> getEvents(Integer userId, String selectedDate);
}
