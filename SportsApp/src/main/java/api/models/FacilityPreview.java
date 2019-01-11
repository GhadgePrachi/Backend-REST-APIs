package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacilityPreview {
    @JsonProperty("facility_id")
    Integer facilityId;

    @JsonProperty("facility_name")
    String facilityName;

    @JsonProperty("address")
    String address;

    @JsonProperty("telephone")
    String telephone;

    @JsonProperty("timings")
    String timings;

    @JsonProperty("ratings")
    String ratings;

    public FacilityPreview() {
        this.facilityId = -1;
        this.facilityName = "";
        this.address = "";
        this.telephone = "";
        this.timings = "";
        this.ratings = "";
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
