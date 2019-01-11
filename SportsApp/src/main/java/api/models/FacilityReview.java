package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacilityReview {
    @JsonProperty("review_id")
    Integer reviewId;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("content")
    String content;

    @JsonProperty("time")
    String time;

    public FacilityReview() {
        this.reviewId = -1;
        this.userName = "";
        this.content = "";
        this.time = "";
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
