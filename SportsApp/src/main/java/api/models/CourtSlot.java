package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourtSlot {
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

    public CourtSlot() {
        this.courtId = -1;
        this.courtName = "";
        this.description = "";
        this.startTime = -1L;
        this.endTime = -1L;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CourtSlot) {
            CourtSlot c = (CourtSlot) o;
            return this.getCourtId().equals(c.getCourtId()) &&
                    this.getStartTime().equals(c.getStartTime()) &&
                    this.getEndTime().equals(c.getEndTime());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getCourtId();
    }
}
