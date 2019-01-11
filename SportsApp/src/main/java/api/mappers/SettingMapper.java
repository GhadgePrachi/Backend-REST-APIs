package api.mappers;

import api.mappers.provider.SettingProvider;
import api.models.SettingAdvanced;
import api.models.SettingGeneral;
import api.utils.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

public interface SettingMapper {
    //Select General Setting
    @SelectProvider(type = SettingProvider.class, method = "buildGeneralSettingQuery")
    @Results({
            @Result(column = Constants.USER_NAME_COLUMN, property = "userName"),
            @Result(column = Constants.USER_EMAIL_COLUMN, property = "emailId"),
            @Result(column = Constants.USER_GENDER_COLUMN, property = "gender"),
            @Result(column = Constants.USER_DOB_COLUMN, property = "dateOfBirth"),
            @Result(column = Constants.USER_LOCATION_COLUMN, property = "location"),
            @Result(column = Constants.USER_BIO_COLUMN, property = "bio")
    })
    SettingGeneral selectGeneralSetting(@Param("userId") Integer userId);

    //Select Advanced Setting
    @SelectProvider(type = SettingProvider.class, method = "buildAdvancedSettingQuery")
    @Results({
            @Result(column = Constants.SETTING_PAYMENT_METHOD_COLUMN, property = "paymentMethod"),
            @Result(column = Constants.SETTING_SHOW_INTEREST_ON_PROFILE_COLUMN, property = "showInterestOnProfile"),
            @Result(column = Constants.SETTING_ALLOW_SEARCHED_BY_NAME_COLUMN, property = "allowBeingSearchedByName")
    })
    SettingAdvanced selectAdvancedSetting(@Param("userId") Integer userId);
}
