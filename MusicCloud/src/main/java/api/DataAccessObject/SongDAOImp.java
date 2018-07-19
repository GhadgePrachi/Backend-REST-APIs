package api.DataAccessObject;

import api.EntityModel.Song;
import api.Mappers.SongMapper;
import api.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SongDAOImp implements SongDAO{

    private static final Logger log = LoggerFactory.getLogger(SongDAOImp.class);
    private SqlSessionFactory sqlSessionFactory = null;
    private final static int ACTIVE = 1;

    public SongDAOImp(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public Song addSong(Song song) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(song!=null){
                song.setTimestamp((Long)System.currentTimeMillis()/1000);
                song.setStatus(ACTIVE);

                SongMapper songMapper = session.getMapper(SongMapper.class);
                int result = songMapper.insertSong(song);
                session.commit();
                if(result>0){
                    log.info("Song created with ID " + song.getId());
                    return song;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error in insert song");

        }finally {
            session.close();
        }
        return null;
    }


    @Override
    public Song getSongById(Integer songId) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(songId!=null && songId > 0){
                SongMapper songMapper = session.getMapper(SongMapper.class);
                Song result = songMapper.getSongById(songId);
                log.info("Song found!");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error in getting song");
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean deleteSongById(Integer songId) {
        SqlSession session = sqlSessionFactory.openSession();
        try{
            if(songId!=null && songId > 0){
                SongMapper songMapper = session.getMapper(SongMapper.class);
                int result = songMapper.deleteSongById(songId);
                session.commit();
                if(result > 0){
                    log.info("Song deleted!");
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            log.error("Error in deleting a song");
        }finally {
            session.close();
        }
        return false;
    }
}
