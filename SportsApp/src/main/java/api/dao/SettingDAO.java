package api.dao;


import api.models.Setting;

public interface SettingDAO {
    public Setting getSetting(Integer userId);
}
