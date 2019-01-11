package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourtReservation {
    @JsonProperty("reservation_id")
    Integer reservation_id;

    @JsonProperty("user_id")
    Integer userId;

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

    @JsonProperty("price")
    String price;

    @JsonProperty("status")
    Integer status;

    public CourtReservation() {
        this.reservation_id = -1;
        this.userId = -1;
        this.courtId = -1;
        this.courtName = "";
        this.description = "";
        this.startTime = -1L;
        this.endTime = -1L;
        this.price = "";
        this.status = -1;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}


