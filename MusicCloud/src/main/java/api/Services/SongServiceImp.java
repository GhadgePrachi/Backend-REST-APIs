package api.Services;

import api.DataAccessObject.SongDAOImp;
import api.EntityModel.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SongServiceImp implements SongService {

    private static final Logger log = LoggerFactory.getLogger(SongServiceImp.class);
    SongDAOImp songDAO = null;

    public SongServiceImp(){
        songDAO = new SongDAOImp();
    }
    @Override
    public Song addSong(Song song) {
        if(songDAO!=null){
            log.info("Done adding song");
            return songDAO.addSong(song);
        }
        return null;
    }

    @Override
    public Song getSongById(Integer songId) {
        if(songDAO!=null){
            log.info("Done reading song");
            return songDAO.getSongById(songId);
        }
        return null;
    }

    @Override
    public boolean deleteSongById(Integer songId) {
        if(songDAO!=null){
            log.info("Done deleting song");
            return songDAO.deleteSongById(songId);
        }
        return false;
    }
}
