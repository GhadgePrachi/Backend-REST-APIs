package api.EntityModel;

public class Song {
    Integer songId;
    Integer status;
    Long timestamp;
    String title;
    String artist;
    String details;
    Double length;

    /**Constructor**/
    public Song(){
        this.title = "";
        this.artist = "";
        this.details = "";
    }

    /**Getter and Setter**/
    public Integer getId() {
        return songId;
    }

    public void setId(int songId) {
        this.songId = songId;
    }

    public Long getTimestamp() { return timestamp; }

    public void setTimestamp(Long timestamp) { this.timestamp = timestamp; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getData() {
        return details;
    }

    public void setData(String data) {
        this.details = data;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

}
