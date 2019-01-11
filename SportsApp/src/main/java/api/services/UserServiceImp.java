package api.services;

import api.dao.UserDAOImp;
import api.models.*;
import api.utils.Constants;
import api.utils.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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

    public UserPreview validateUser(User user){
        if(user!=null){
            return userDAO.validateUser(user);
        }
        return null;
    }

    public User getUser(Integer userId){
        if(userId>0){
            return userDAO.getUser(userId);
        }
        return null;
    }

    public UserProfile getProfile(Integer userId){
        if(userId>0){
            return userDAO.getProfile(userId);
        }
        return null;
    }

    public List<EventsGroupedByDate> getEvents(Integer userId, String selectedDate){
        if(userId>0){
            List<Event> events = userDAO.getEvents(userId,selectedDate);
            return  groupByDates(events);
        }
        return null;
    }

    public List<EventsGroupedByDate> groupByDates(List<Event> events) {
        //TODO : Put these in two separate methods
        //Build HashMap with date as key and list of events scheduled for the date as value
        SortedMap<String, List<Event>> eventsGroupedByDateMap =
                new TreeMap<String, List<Event>>(new Comparator<String>()
                {
                    public int compare(String o1, String o2)
                    {
                        String oneDate = o1.split(",")[1];
                        String twoDate = o2.split(",")[1];
                        return oneDate.compareTo(twoDate);
                    }
                });
        List<Event> groupedEvents;

        for(Event event:events){
            String time = DateTime.getTimeRange(event.getStartTime(),event.getEndTime(), Constants.DATE_FORMATTER_HOUR_MINUTES_PATTERN,Constants.HYPHEN_SYMBOL);
            event.setTime(time);

            String date = DateTime.getDateString(event.getStartTime(),Constants.DATE_FORMATTER_DAY_DATE_PATTERN);
            if(!eventsGroupedByDateMap.containsKey(date)){
                groupedEvents = new ArrayList<>();
            }else {
                groupedEvents = eventsGroupedByDateMap.get(date);
            }
            groupedEvents.add(event);
            eventsGroupedByDateMap.put(date,groupedEvents);
        }

        //Convert HashMap to List of EventsGroupedByDate
        List<EventsGroupedByDate> eventsGroupedByDatesList = new ArrayList<>();
        Iterator iterator = eventsGroupedByDateMap.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry courtEntry = (Map.Entry) iterator.next();
            String courtsDate = (String)courtEntry.getKey();
            List<Event> eventsList = (List<Event>) courtEntry.getValue();

            EventsGroupedByDate eventsGroupedByDate = new EventsGroupedByDate();
            eventsGroupedByDate.setDate(courtsDate);
            eventsGroupedByDate.setEventsList(eventsList);

            eventsGroupedByDatesList.add(eventsGroupedByDate);
        }
        return eventsGroupedByDatesList;
    }
}
