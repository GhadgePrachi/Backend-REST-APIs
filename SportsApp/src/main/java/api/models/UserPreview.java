package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPreview {
    @JsonProperty("user_id")
    Integer userId;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("image_url")
    String imageUrl;

    public UserPreview(){
        this.userName = "";
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
