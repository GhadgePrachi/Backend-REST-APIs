package api.Controllers;

import api.EntityModel.Error;
import api.EntityModel.Song;
import api.EntityModel.User;
import api.Services.PlaylistServiceImp;
import api.Services.SongServiceImp;
import api.Services.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicCloudController {

    private static final Logger log = LoggerFactory.getLogger(MusicCloudController.class);
    UserServiceImp userService =  new UserServiceImp();
    SongServiceImp songService = new SongServiceImp();
    PlaylistServiceImp playlistService = new PlaylistServiceImp();
    ObjectMapper mapper = new ObjectMapper();

    /**DEFAULT**/
    @RequestMapping(method = RequestMethod.GET , value ="/status")
    public ResponseEntity<?> getStatus(){
        try{
            //Its here that means our API is up to hit
            return new ResponseEntity<Object>("{'status' : 'API is up and running!'}", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error in API Status");
            Error error = new Error("Error occurred in getting spot by the requested type!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    /**USER**/
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.createUser(user));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user creation . Please provide First name , Last name and email ID");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error in creating User");
            Error error = new Error("Error in creating user!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }


    /**SONG**/
    @RequestMapping(method = RequestMethod.POST , value = "/songs")
    public ResponseEntity<?> addSong(@RequestBody Song song){
        try{
            //Verification of song details is required before processing further
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(songService.addSong(song));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since song has a problem");
                Error error = new Error("User : Error in adding  song. Please provide Song title , artist, details and length text as required.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Alert : Error in adding song");
            Error error = new Error("Alert : Error in adding Song!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/songs/{songId}")
    public ResponseEntity<?> getSongBySongId(@PathVariable Integer songId){
        try{
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(songService.getSongById(songId));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.info("Sending error message since song has problem");
                Error error = new Error("User : Error in song retrieval. Please provide Song ID as required.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.info("Error in getting song by song id" + songId);
            Error error = new Error("Severe : Error in getting song by id " + songId);
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value =  "/songs/{songId}")
    public ResponseEntity<?> deleteSongtById(@PathVariable Integer songId){
        try{
            Boolean result = songService.deleteSongById(songId);
            if(result)
                return new ResponseEntity<Object>("{'result' : 'Delete done '}", HttpStatus.OK);
            else{
                Error error = new Error("Error in deleting songs " +songId);
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            log.info("Error in deleting tweet" + songId);
            Error error = new Error("Severe : Error in deleting song " + songId);
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.OK);
        }
    }

    /**PLAYLIST**/
    //TODO:

}
