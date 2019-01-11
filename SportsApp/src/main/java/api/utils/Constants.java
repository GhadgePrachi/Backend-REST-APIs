package api.utils;

public class Constants {
    /**DB SCHEMA**/
    /**Users Table**/
    public static final String USERS_TABLE = "users";
    public static final String USER_ID_COLUMN = "user_id";
    public static final String USER_NAME_COLUMN = "user_name";
    public static final String USER_EMAIL_COLUMN = "email";
    public static final String USER_PASSWORD_COLUMN = "password";
    public static final String USER_GENDER_COLUMN = "gender";
    public static final String USER_DOB_COLUMN= "date_of_birth";
    public static final String USER_LOCATION_COLUMN = "location";
    public static final String USER_TWITTER_LINK_COLUMN = "twitter_link";
    public static final String USER_FACEBOOK_LINK_COLUMN = "facebook_link";
    public static final String USER_MEMBER_SINCE_COLUMN = "member_since";
    public static final String USER_BIO_COLUMN = "bio";
    public static final String USER_IMAGE_URL_COLUMN = "image_url";
    public static final String USER_STATUS = "status";

    /**Settings Table**/
    public static final String SETTINGS_TABLE = "settings";
    public static final String SETTING_PAYMENT_METHOD_COLUMN = "payment_method";
    public static final String SETTING_SHOW_INTEREST_ON_PROFILE_COLUMN = "show_interest_on_profile";
    public static final String SETTING_ALLOW_SEARCHED_BY_NAME_COLUMN = "allow_being_searched_by_name";

    /**Facilities Table**/
    public static final String FACILITIES_TABLE = "facilities";
    public static final String FACILITY_ID_COLUMN = "facility_id";
    public static final String FACILITY_NAME_COLUMN = "facility_name";
    public static final String FACILITY_CATEGORY_COLUMN = "category";
    public static final String FACILITY_ADDRESS_COLUMN = "address";
    public static final String FACILITY_TELEPHONE_COLUMN = "telephone";
    public static final String FACILITY_TIMINGS_COLUMN = "timings";
    public static final String FACILITY_RATINGS_COLUMN = "ratings";
    public static final String FACILITY_SUMMARY_COLUMN = "summary";
    public static final String FACILITY_IMAGE_URL_COLUMN = "image_url";

    /**Reviews Table**/
    public static final String REVIEWS_TABLE = "reviews";
    public static final String REVIEW_ID_COLUMN = "review_id";
    public static final String REVIEW_FACILITY_ID_COLUMN = "facility_id";
    public static final String REVIEW_USER_ID_COLUMN = "user_id";
    public static final String REVIEW_CONTENT_COLUMN = "content";
    public static final String REVIEW_TIMING_COLUMN = "timing";

    /**Courts Table**/
    public static final String COURTS_TABLE = "courts";
    public static final String COURT_ID_COLUMN = "court_id";
    public static final String COURT_NAME_COLUMN = "court_name";
    public static final String COURT_HOURLY_PRICE_COLUMN = "hourly_price";


    /**Court_Reservation Table**/
    public static final String COURT_RESERVATION_TABLE = "court_reservation";
    public static final String COURT_RESERVATION_ID_COLUMN = "reservation_id";
    public static final String COURT_RESERVATION_COURT_ID_COLUMN = "court_id";
    public static final String COURT_RESERVATION_USER_ID_COLUMN = "user_id";
    public static final String COURT_RESERVATION_DESCRIPTION_COLUMN = "description";
    public static final String COURT_RESERVATION_START_TIME_COLUMN = "start_time";
    public static final String COURT_RESERVATION_END_TIME_COLUMN = "end_time";
    public static final String COURT_RESERVATION_PRICE_COLUMN = "price";

    public static final String ALL_COLUMNS = "*";

    public static final int STATUS_ACTIVE = 1;

    /**DateTime Conversions**/
    public static final int NUMBER_OF_SECONDS_PER_DAY = 86400;
    public static final int NUMBER_OF_SECONDS_PER_HOUR = 3600;

    public static final int START_TIMINGS_FOR_THE_DAY = 6;
    public static final int END_TIMINGS_FOR_THE_DAY = 21;

    public static final int ONE_KILO = 1000;

    public static final String DATE_FORMATTER_DATE_PATTERN = "MM/dd/yyyy";
    public static final String DATE_FORMATTER_DAY_DATE_PATTERN = "EEEEE, MM-dd-yyyy";
    public static final String DATE_FORMATTER_HOUR_MINUTES_PATTERN = "hh:mm a";

    public static final String HYPHEN_SYMBOL = " - ";

}
