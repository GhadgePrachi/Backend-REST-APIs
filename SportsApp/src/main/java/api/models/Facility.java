package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Facility {
    @JsonProperty("facility_id")
    Integer facilityId;

    @JsonProperty("facility_name")
    String facilityName;

    @JsonProperty("category")
    String category;

    @JsonProperty("address")
    String address;

    @JsonProperty("telephone")
    String telephone;

    @JsonProperty("timings")
    String timings;

    @JsonProperty("ratings")
    String ratings;

    @JsonProperty("summary")
    String summary;

    @JsonProperty("image_url")
    String imageUrl;

    public Facility() {
        this.facilityId = -1;
        this.facilityName = "";
        this.category = "";
        this.address = "";
        this.telephone = "";
        this.timings = "";
        this.ratings = "";
        this.summary = "";
        this.imageUrl = "";
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
