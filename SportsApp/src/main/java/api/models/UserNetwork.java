package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserNetwork {
    @JsonProperty("twitter_link")
    String twitterLink;

    @JsonProperty("facebook_link")
    String facebookLink;

    public UserNetwork() {
        this.twitterLink = "";
        this.facebookLink = "";
    }

    public UserNetwork(String twitterLink, String facebookLink){
        this.twitterLink = twitterLink;
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

}
