package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfile {
    @JsonProperty("user_id")
    Integer userId;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("email_id")
    String emailId;

    @JsonProperty("gender")
    String gender;

    @JsonProperty("date_of_birth")
    String dateOfBirth;

    @JsonProperty("location")
    String location;

    @JsonProperty("member_since")
    String memberSince;

    @JsonProperty("network")
    UserNetwork network;

    @JsonProperty("bio")
    String bio;

    @JsonProperty("image_url")
    String imageUrl;

    public UserProfile(){
        this.userName = "";
        this.emailId = "";
        this.gender = "";
        this.dateOfBirth = "";
        this.location = "";
        this.memberSince = "";
        this.bio = "";
        this.imageUrl = "";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public UserNetwork getNetwork() {
        return network;
    }

    public void setNetwork(UserNetwork network) {
        this.network = network;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
