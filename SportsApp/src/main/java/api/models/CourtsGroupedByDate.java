package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CourtsGroupedByDate {
    @JsonProperty("date")
    String date;

    @JsonProperty("courts_available_list")
    List<CourtAvailable> courtsAvailableList;

    public CourtsGroupedByDate() {
        this.date = "";
        this.courtsAvailableList = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CourtAvailable> getCourtsAvailableList() {
        return courtsAvailableList;
    }

    public void setCourtsAvailableList(List<CourtAvailable> courtsAvailableList) {
        this.courtsAvailableList = courtsAvailableList;
    }
}
