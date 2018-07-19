package api.Services;

import api.EntityModel.Song;

public interface SongService {
    public Song addSong(Song song);
    public Song getSongById(Integer songId);
    public boolean deleteSongById(Integer songId);
}
