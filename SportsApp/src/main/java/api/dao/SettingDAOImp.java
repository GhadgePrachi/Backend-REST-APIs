package api.dao;
import api.MyBatisConnectionFactory;
import api.mappers.SettingMapper;
import api.models.SettingAdvanced;
import api.models.SettingGeneral;
import api.models.Setting;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SettingDAOImp {
    private static final Logger log = LoggerFactory.getLogger(SettingDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;

    public SettingDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public Setting getSetting(Integer userId){
        SqlSession session = sqlSessionFactory.openSession();
        if(userId>0){
            SettingMapper settingMapper = session.getMapper(SettingMapper.class);
            Setting result = new Setting();
            SettingGeneral generalSetting = settingMapper.selectGeneralSetting(userId);
            SettingAdvanced advancedSetting = settingMapper.selectAdvancedSetting(userId);
            if(advancedSetting==null){
                advancedSetting = new SettingAdvanced(); //in case object is empty still create object with null set attributes
            }
            result.setGeneral(generalSetting);
            result.setAdvanced(advancedSetting);
            session.commit();

            if(result!=null){
                log.info("User exists with id : " + userId);
                return result;
            }
        }
        return null;
    }

}
