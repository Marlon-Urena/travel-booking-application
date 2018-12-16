import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.parse;

public class Schedule {
    private LocalDate startDate;
    private LocalDate endDate;
    Map<LocalDate, String> scheduleMap = new HashMap<>();

    public boolean setDates(String startDate, String endDate){
        try {
            if (areDatesValid(startDate, endDate)) {
                this.startDate = parse(startDate);
                this.endDate = parse(endDate);
                return true;
            }
        }catch (DateTimeParseException e) {
            return false;
        }
       return false;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void addActivityToSchedule(LocalDate date, String activity){
        scheduleMap.put(date, activity);
    }

    public void printSchedule(){
        System.out.print(scheduleMap);
    }

    public boolean areDatesValid(String start, String end) {
        LocalDate date = LocalDate.now();
        try {
            LocalDate startingDate = parse(start);
            LocalDate endingDate = parse(end);
            if (startingDate.isAfter(date)) {
                if (endingDate.isAfter(startingDate)) {
                    return true;
                }
            }
        }
        catch (DateTimeParseException e) {
            System.out.println("One of your dates are not in the valid format. yyyy-MM-dd");
            return false;
        }
        return false;
    }

    public LocalDate isDateValid(String date) throws IOException, DateTimeParseException{
        LocalDate today = LocalDate.now();
        LocalDate testDate;
        try {
            testDate = parse(date);
            if (testDate.isAfter(today)) {
                return testDate;
            }
            else {
                throw new IOException();
            }
        }
        catch (DateTimeParseException e) {
            throw e;
        }
    }
}
