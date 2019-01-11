package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Setting {
    @JsonProperty("general")
    SettingGeneral general;

    @JsonProperty("advanced")
    SettingAdvanced advanced;

    public Setting(SettingGeneral general, SettingAdvanced advanced){
        this.general = general;
        this.advanced = advanced;
    }

    public Setting () {}

    public SettingGeneral getGeneral() {
        return general;
    }

    public void setGeneral(SettingGeneral general) {
        this.general = general;
    }

    public SettingAdvanced getAdvanced() {
        return advanced;
    }

    public void setAdvanced(SettingAdvanced advanced) {
        this.advanced = advanced;
    }
}
