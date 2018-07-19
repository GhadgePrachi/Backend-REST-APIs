package api.Mappers;

import api.EntityModel.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

public interface UserMapper {

    final String insert = "INSERT into Users(user_id,first_name,last_name,email_id,status) VALUES(#{userId},#{firstName},#{lastName},#{emailId},#{status})";

    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "last_name", property = "lastName"),
            @Result(column = "email_id", property = "emailId"),
            @Result(column = "status", property = "status"),
    })

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insertUser(User u);
}
