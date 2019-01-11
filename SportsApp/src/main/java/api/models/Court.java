package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Court {
    @JsonProperty("court_id")
    Integer courtId;

    @JsonProperty("court_name")
    String courtName;

    @JsonProperty("price")
    String price;

    public Court() {
        this.courtId = -1;
        this.courtName = "";
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
