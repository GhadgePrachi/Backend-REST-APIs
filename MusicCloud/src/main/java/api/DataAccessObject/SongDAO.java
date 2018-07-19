package api.DataAccessObject;

import api.EntityModel.Playlist;
import api.EntityModel.Song;

import java.util.List;

public interface SongDAO {
    public Song addSong(Song song);
    public Song getSongById(Integer songId);
    public boolean deleteSongById(Integer songId);
}
