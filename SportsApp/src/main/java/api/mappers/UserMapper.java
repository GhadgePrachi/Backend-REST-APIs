package api.mappers;

import api.mappers.provider.UserProvider;
import api.models.*;
import api.utils.Constants;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //Insert User
    @InsertProvider(type = UserProvider.class, method = "buildCreateUserQuery")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insertUser(User u);

    //Select User
    @SelectProvider(type = UserProvider.class, method = "buildSelectUserQueryByEmailAndPassword")
    @Results({
            @Result(column = Constants.USER_ID_COLUMN, property = "userId"),
            @Result(column = Constants.USER_NAME_COLUMN, property = "userName"),
            @Result(column = Constants.USER_IMAGE_URL_COLUMN, property = "imageUrl")
    })
    UserPreview selectUser(User u);

    //Select User By User Id
    @SelectProvider(type = UserProvider.class, method = "buildSelectUserByIdQuery")
    @Results({
            @Result(column = Constants.USER_ID_COLUMN, property = "userId"),
            @Result(column = Constants.USER_NAME_COLUMN, property = "userName"),
            @Result(column = Constants.USER_EMAIL_COLUMN, property = "emailId"),
            @Result(column = Constants.USER_GENDER_COLUMN, property = "gender"),
            @Result(column = Constants.USER_DOB_COLUMN, property = "dateOfBirth"),
            @Result(column = Constants.USER_LOCATION_COLUMN, property = "location"),
            @Result(column = Constants.USER_MEMBER_SINCE_COLUMN, property = "memberSince"),
            @Result(column = Constants.USER_BIO_COLUMN, property = "bio"),
            @Result(column = Constants.USER_IMAGE_URL_COLUMN, property = "imageUrl")
    })
    User selectUserById(@Param("userId")Integer userId);

    //Select Profile By User Id
    @SelectProvider(type = UserProvider.class, method = "buildSelectUserByIdQuery")
    @Results({
            @Result(column = Constants.USER_ID_COLUMN, property = "userId"),
            @Result(column = Constants.USER_NAME_COLUMN, property = "userName"),
            @Result(column = Constants.USER_EMAIL_COLUMN, property = "emailId"),
            @Result(column = Constants.USER_GENDER_COLUMN, property = "gender"),
            @Result(column = Constants.USER_DOB_COLUMN, property = "dateOfBirth"),
            @Result(column = Constants.USER_LOCATION_COLUMN, property = "location"),
            @Result(column = Constants.USER_MEMBER_SINCE_COLUMN, property = "memberSince"),
            @Result(column = Constants.USER_BIO_COLUMN, property = "bio"),
            @Result(column = Constants.USER_IMAGE_URL_COLUMN, property = "imageUrl")
    })
    UserProfile selectProfile(@Param("userId") Integer userId);

    //Select Network By User Id
    @SelectProvider(type = UserProvider.class, method = "buildSelectUserByIdQuery")
    @Results({

            @Result(column = Constants.USER_TWITTER_LINK_COLUMN, property = "twitterLink"),
            @Result(column = Constants.USER_FACEBOOK_LINK_COLUMN, property = "facebookLink")
    })
    UserNetwork selectNetwork(@Param("userId") Integer userId);


    //Select Events By User Id
    @SelectProvider(type = UserProvider.class, method = "buildSelectEventsByIdQuery")
    @Results({
            @Result(column = Constants.COURT_NAME_COLUMN, property = "courtName"),
            @Result(column = Constants.FACILITY_NAME_COLUMN, property = "facilityName"),
            @Result(column = Constants.COURT_RESERVATION_START_TIME_COLUMN, property = "startTime"),
            @Result(column = Constants.COURT_RESERVATION_END_TIME_COLUMN, property = "endTime"),

    })
    List<Event> selectEventsById(@Param("userId")Integer userId, @Param("selectedDate")String selectedDate);
}
