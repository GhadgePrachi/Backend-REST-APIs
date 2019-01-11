package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("facility_name")
    String facilityName;

    @JsonProperty("court_name")
    String courtName;

    @JsonProperty("description")
    String description;

    @JsonProperty("start_time")
    Long startTime;

    @JsonProperty("end_time")
    Long endTime;

    @JsonProperty("time")
    String time;

    public Event() {
        this.facilityName = "";
        this.courtName = "";
        this.description = "";
        this.startTime = -1L;
        this.endTime = -1L;
        this.time = "";
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
