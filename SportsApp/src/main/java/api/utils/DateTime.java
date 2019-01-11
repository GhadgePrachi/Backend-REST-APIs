package api.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static String getCurrentDate(String datePattern){
        Long startTime = System.currentTimeMillis()/Constants.ONE_KILO;
        return getDateString(startTime,datePattern);
    }

    public static String getDatePlusMonths(String startDate,int months, String datePattern){
        String endDate ="";
        Date startTime = getDateFromString(startDate,datePattern);
        DateFormat format = new SimpleDateFormat(datePattern);
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        c.add(Calendar.MONTH, +months);
        Date d = c.getTime();
        endDate = format.format(d);

        return endDate;
    }
    public static String getTimeRange(Long startTime, Long endTime, String datePattern, String separator){
        String time;

        String startHour = getDateString(startTime,datePattern);
        String endHour = getDateString(endTime,datePattern);

        time = startHour + separator + endHour ;
        return time;
    }

    public static String getDateString(Long timestamp, String datePattern){
        Date courtAvailableDate = new Date(timestamp*Constants.ONE_KILO);
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(courtAvailableDate);
    }

    public static Timestamp getTimestampFromString(String date, String datePattern){

        Timestamp dateTimeStamp = null;
        Date currentDate = getDateFromString(date,datePattern);
        dateTimeStamp = new Timestamp(currentDate.getTime());
        return dateTimeStamp;
    }

    public  static Date getDateFromString(String date,  String datePattern){
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        Date currentDate = null;

        try {
            currentDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }
}
