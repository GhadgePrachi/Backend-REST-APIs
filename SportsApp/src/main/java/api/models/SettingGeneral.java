package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingGeneral {
    @JsonProperty("user_name")
    String userName;

    @JsonProperty("email_id")
    String emailId;

    @JsonProperty("password")
    String password;

    @JsonProperty("gender")
    String gender;

    @JsonProperty("date_of_birth")
    String dateOfBirth;

    @JsonProperty("location")
    String location;

    @JsonProperty("bio")
    String bio;

    public SettingGeneral(){
        this.userName = "";
        this.emailId = "";
        this.password = "";
        this.gender = "";
        this.dateOfBirth = "";
        this.location = "";
        this.bio = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
