package api.Mappers;

import api.EntityModel.Song;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface SongMapper {
    final String getById = "SELECT * from Songs WHERE song_id = #{songId} AND status = 1 ORDER by timestamp DESC";
    final String deleteById = "UPDATE Songs SET status = 0 WHERE song_id=#{songId}";
    final String insert = "INSERT into Songs(title,status,artist,details,length) VALUES(#{title},#{status},#{artist},#{details},#{length})";

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "songId")
    Integer insertSong(Song s);

    @Select(getById)
    @Results({
            @Result(column = "song_id", property = "songId"),
            @Result(column = "timestamp", property = "timestamp"),
            @Result(column = "status", property = "status"),
            @Result(column = "title", property = "title"),
            @Result(column = "artist", property = "artist"),
            @Result(column = "details", property = "details"),
            @Result(column = "length", property = "length")
    })
    Song getSongById(int songId);

    @Update(deleteById)
    Integer deleteSongById(int songId);
}


