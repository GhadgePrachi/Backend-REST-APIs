package api.EntityModel;

import java.util.ArrayList;

public class Playlist {
    Integer playlistId;
    Integer status;
    Long timestamp;
    String name;
    String details;

    /**Constructor**/
    public Playlist() { }

    /**Getter and Setter**/
    public Integer getId() {
        return playlistId;
    }

    public void setId(int playlistId) {
        this.playlistId = playlistId;
    }

    public Long getTimestamp() { return timestamp; }

    public void setTimestamp(Long timestamp) { this.timestamp = timestamp; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

}
