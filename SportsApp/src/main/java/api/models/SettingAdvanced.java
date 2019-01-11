package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SettingAdvanced {
    @JsonProperty("payment_method")
    String paymentMethod;

    @JsonProperty("show_interest_on_profile")
    String showInterestOnProfile;

    @JsonProperty("allow_being_searched_by_name")
    String allowBeingSearchedByName;

    public SettingAdvanced(){
        this.paymentMethod = "";
        this.showInterestOnProfile = "";
        this.allowBeingSearchedByName = "";
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShowInterestOnProfile() {
        return showInterestOnProfile;
    }

    public void setShowInterestOnProfile(String showInterestOnProfile) {
        this.showInterestOnProfile = showInterestOnProfile;
    }

    public String getAllowBeingSearchedByName() {
        return allowBeingSearchedByName;
    }

    public void setAllowBeingSearchedByName(String allowBeingSearchedByName) {
        this.allowBeingSearchedByName = allowBeingSearchedByName;
    }
}
