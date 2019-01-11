package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourtAvailable {
    @JsonProperty("court_id")
    Integer courtId;

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

    @JsonProperty("price")
    String price;

    public CourtAvailable() {
        this.courtId = -1;
        this.courtName = "";
        this.description = "";
        this.startTime = -1L;
        this.endTime = -1L;
        this.time = "";
        this.price = "";
    }

    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
