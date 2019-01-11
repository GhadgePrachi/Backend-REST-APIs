package api.controllers;

import api.models.Error;
import api.models.User;
import api.models.CourtReservation;
import api.services.UserServiceImp;
import api.services.SettingServiceImp;
import api.services.FacilityServiceImp;
import api.services.CourtServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SportsAppController {
    private static final Logger log = LoggerFactory.getLogger(SportsAppController.class);
    UserServiceImp userService =  new UserServiceImp();
    SettingServiceImp settingService = new SettingServiceImp();
    FacilityServiceImp facilityService = new FacilityServiceImp();
    CourtServiceImp courtService = new CourtServiceImp();
    ObjectMapper mapper = new ObjectMapper();

    /**USER**/
    @CrossOrigin(origins = "http://localhost:3000")
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
                Error error = new Error("Error in user creation . Please provide Name, Username, Password and Location");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error in creating User");
            Error error = new Error("Error in creating user!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value="/login")
    public ResponseEntity<?> validateUser(@RequestBody User user){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.validateUser(user));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user validation . Please provide valid Username and Password");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in logging User");
            Error error = new Error("Error in logging user!");
            return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value="/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Integer userId){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.getUser(userId));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user info retrieval . Please provide valid user id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting User");
            Error error = new Error("Error in getting user!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value="/users/{userId}/profile")
    public ResponseEntity<?> getProfile(@PathVariable Integer userId){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userService.getProfile(userId));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user's profile info retrieval . Please provide valid user id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting User's Profile");
            Error error = new Error("Error in getting user's profile!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/users/{userId}/settings")
    public ResponseEntity<?> getSetting(@PathVariable Integer userId){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((settingService.getSetting(userId)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user's setting info retrieval . Please provide valid user id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting User's Settings");
            Error error = new Error("Error in getting user's setting!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/users/{userId}/events")
    public ResponseEntity<?> getEvents(@PathVariable Integer userId, @RequestParam("selected_date") String selectedDate){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((userService.getEvents(userId, selectedDate)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in user's events info retrieval . Please provide valid user id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting User's events");
            Error error = new Error("Error in getting user's events!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**FACILITY**/
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/facilities")
    public ResponseEntity<?> getCourts(@RequestParam("category") String category, @RequestParam("location") String location ){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((facilityService.getFacilities(category,location)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in facilities info retrieval . Please provide valid category/location/date");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting Facilities's Info");
            Error error = new Error("Error in getting facilities's info!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/facilities/{facilityId}/details")
    public ResponseEntity<?> getFacilityDetails(@PathVariable Integer facilityId){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((facilityService.getFacilityDetails(facilityId)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in facility's info retrieval . Please provide valid facility id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting Facility's Info");
            Error error = new Error("Error in getting facility's info!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/facilities/{facilityId}/reviews")
    public ResponseEntity<?> getFacilityReviews(@PathVariable Integer facilityId){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((facilityService.getFacilityReviews(facilityId)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in facility's review info retrieval . Please provide valid facility id");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting Facility's Reviews");
            Error error = new Error("Error in getting facility's reviews!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET, value="/facilities/{facilityId}/courts")
    public ResponseEntity<?> getFacilityCourts(@PathVariable Integer facilityId, @RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((courtService.getCourts(facilityId,startDate,endDate)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in facility's courts info retrieval . Please provide valid facility id, start and end date.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in getting Facility's courts");
            Error error = new Error("Error in getting facility's courts!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST, value="/reserve")
    public ResponseEntity<?> reserveCourt(@RequestBody CourtReservation courtReservation){
        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString((courtService.reserveCourt(courtReservation)));
            if(message != null && !message.equals("null")) {
                log.info("Message is " + message + "with length " + message.length());
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }
            else {
                log.error("Sending error message since info is not correctly passed");
                Error error = new Error("Error in court reservation . Please provide valid court name, time-slot and price.");
                return new ResponseEntity<Object>(error.getErrorMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Error in reserving Court");
            Error error = new Error("Error in reserving court!");
            return new ResponseEntity<Object>(error.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
