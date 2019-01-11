package api.services;

import api.dao.CourtDAOImp;
import api.models.*;
import api.utils.Constants;
import api.utils.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;

public class CourtServiceImp {
    private static final Logger log = LoggerFactory.getLogger(CourtService.class);
    CourtDAOImp courtDAO = null;

    public CourtServiceImp() {
        courtDAO = new CourtDAOImp();
    }

    public List<CourtsGroupedByDate> getCourts(Integer facilityId, String startDate, String endDate) {
        if (facilityId > 0) {
            //Generate all possible slots for courts affiliated to given facility
            List<CourtSlot> possibleCourtSlots = generateAllSlots(facilityId, startDate, endDate);

            //Get the reserved list for courts affiliated to given facility
            List<CourtSlot> reservedCourtSlots = getReservedSlots(facilityId, startDate, endDate);

            //Generate available time slots list from the reserved court list
            return generateAvailableCourtSlots(possibleCourtSlots, reservedCourtSlots);
        }
        return null;
    }

    public CourtReservation reserveCourt(CourtReservation courtReservation) {
        if (courtReservation != null) {
            return courtDAO.reserveCourt(courtReservation);
        }
        return null;
    }

    /**
     * Utility Methods
     **/

    public List<CourtSlot> generateAllSlots(Integer facilityId, String startDate, String endDate) {
        //Get list of all court from the db
        List<Court> courts = courtDAO.getAllCourts(facilityId);

        //Generate 1 hour slots starting from startDate 6am to endDate 9pm for all courts
        List<CourtSlot> possibleCourts = new ArrayList<>();
        if(startDate==null || startDate.length()==0) {
            startDate = DateTime.getCurrentDate(Constants.DATE_FORMATTER_DATE_PATTERN);
        }
        if(endDate==null || endDate.length()==0) {
            endDate = DateTime.getDatePlusMonths(startDate,1,Constants.DATE_FORMATTER_DATE_PATTERN);
        }

        Timestamp startTimestamp = DateTime.getTimestampFromString(startDate, Constants.DATE_FORMATTER_DATE_PATTERN);

        Timestamp endTimestamp = DateTime.getTimestampFromString(endDate, Constants.DATE_FORMATTER_DATE_PATTERN);

        for (Court court : courts) {
            for (long j = startTimestamp.getTime()/Constants.ONE_KILO; j <= endTimestamp.getTime()/Constants.ONE_KILO; j = j + Constants.NUMBER_OF_SECONDS_PER_DAY) {
                for (long i = Constants.START_TIMINGS_FOR_THE_DAY; i < Constants.END_TIMINGS_FOR_THE_DAY; i++) {
                    CourtSlot courtSlot = new CourtSlot();
                    //add time slots and court attributes to CourtSlot object
                    courtSlot.setCourtId(court.getCourtId());
                    courtSlot.setCourtName(court.getCourtName());
                    courtSlot.setPrice(court.getPrice());
                    courtSlot.setStartTime(j + (i * Constants.NUMBER_OF_SECONDS_PER_HOUR));
                    courtSlot.setEndTime(j + ((i + 1) * Constants.NUMBER_OF_SECONDS_PER_HOUR));

                    //add CourtSlot object to list
                    possibleCourts.add(courtSlot);
                }
            }
        }
        return possibleCourts;
    }


    public List<CourtSlot> getReservedSlots(Integer facilityId, String startDate, String endDate) {
        return courtDAO.getReservedCourts(facilityId, startDate, endDate);
    }

    public List<CourtsGroupedByDate> generateAvailableCourtSlots(List<CourtSlot> possibleCourtSlots, List<CourtSlot> courtReservations) {
        //Remove reserved slots from all possible slots generated
        for (CourtSlot reservedCourt : courtReservations) {
            possibleCourtSlots.remove(reservedCourt);
        }
        return groupByDates(possibleCourtSlots);
    }

    public List<CourtsGroupedByDate> groupByDates(List<CourtSlot> possibleCourtSlots) {
        //TODO : Put these in two separate methods
        //Build HashMap with date as key and list of courts available for the date as value
        SortedMap<String, List<CourtAvailable>> courtsGroupedByDateMap =
                new TreeMap<String, List<CourtAvailable>>(new Comparator<String>()
                {
                    public int compare(String o1, String o2)
                    {
                        String oneDate = o1.split(",")[1];
                        String twoDate = o2.split(",")[1];
                        return oneDate.compareTo(twoDate);
                    }
                });
        List<CourtAvailable> courtsAvailable;

        for (CourtSlot courtSlot : possibleCourtSlots) {
            CourtAvailable courtAvailable = new CourtAvailable();
            courtAvailable.setCourtId(courtSlot.getCourtId());
            courtAvailable.setCourtName(courtSlot.getCourtName());
            courtAvailable.setDescription(courtSlot.getDescription());
            courtAvailable.setStartTime(courtSlot.getStartTime());
            courtAvailable.setEndTime(courtSlot.getEndTime());
            courtAvailable.setPrice(courtSlot.getPrice());
            String time = DateTime.getTimeRange(courtSlot.getStartTime(), courtSlot.getEndTime(),Constants.DATE_FORMATTER_HOUR_MINUTES_PATTERN, Constants.HYPHEN_SYMBOL);
            courtAvailable.setTime(time);

            String date = DateTime.getDateString(courtSlot.getStartTime(),Constants.DATE_FORMATTER_DAY_DATE_PATTERN);
            if (!courtsGroupedByDateMap.containsKey(date)) {
                courtsAvailable = new ArrayList<>();
            } else {
                courtsAvailable = courtsGroupedByDateMap.get(date);
            }
            courtsAvailable.add(courtAvailable);
            courtsGroupedByDateMap.put(date, courtsAvailable);
        }

        //Convert HashMap to List of CourtsGroupedByDate
        List<CourtsGroupedByDate> courtsGroupedByDatesList = new ArrayList<>();
        Iterator iterator = courtsGroupedByDateMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry courtEntry = (Map.Entry) iterator.next();
            String courtsDate = (String) courtEntry.getKey();
            List<CourtAvailable> courtsList = (List<CourtAvailable>) courtEntry.getValue();

            CourtsGroupedByDate courtsGroupedByDate = new CourtsGroupedByDate();
            courtsGroupedByDate.setDate(courtsDate);
            courtsGroupedByDate.setCourtsAvailableList(courtsList);

            courtsGroupedByDatesList.add(courtsGroupedByDate);
        }
        return courtsGroupedByDatesList;
    }

}