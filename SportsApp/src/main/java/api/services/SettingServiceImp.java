package api.services;

import api.dao.SettingDAOImp;
import api.models.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SettingServiceImp {
    private static final Logger log = LoggerFactory.getLogger(SettingService.class);
    SettingDAOImp settingDAO = null;
    public SettingServiceImp(){
        settingDAO = new SettingDAOImp();
    }

    public Setting getSetting(Integer userId){
        if(userId>0){
            return settingDAO.getSetting(userId);
        }
        return null;
    }
}
