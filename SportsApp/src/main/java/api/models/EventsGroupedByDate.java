package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class EventsGroupedByDate {
    @JsonProperty("date")
    String date;

    @JsonProperty("events_list")
    List<Event> eventsList;

    public EventsGroupedByDate() {
        this.date = "";
        this.eventsList = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }
}
