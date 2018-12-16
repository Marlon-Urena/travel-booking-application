import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {
    private Date startDate;
    private Date endDate;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Map<Date, String> scheduleMap = new HashMap<>();

    public boolean setDates(String startDate, String endDate){
        try {
            if (areDatesValid(startDate, endDate)) {
                this.startDate = format.parse(startDate);
                this.endDate = format.parse(endDate);
                return true;
            }
        }catch (ParseException e) {
            return false;
        }
       return false;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void addActivityToSchedule(Date date, String activity){
        scheduleMap.put(date, activity);
    }

    public void printSchedule(){
        System.out.print(scheduleMap);
    }

    private boolean areDatesValid(String start, String end) {
        Date date = new Date();
        try {
            Date startingDate = format.parse(start);
            Date endingDate = format.parse(end);
            if (startingDate.after(date)) {
                if (endingDate.after(startingDate)) {
                    return true;
                }
            }
        }
        catch (ParseException e) {
            System.out.println("One of your dates are not in the valid format. yyyy-MM-dd");
            return false;
        }
        return false;
    }

    public Date isDateValid(String date) throws IOException, ParseException{
        format.setLenient(false);
        Date today = new Date();
        Date testDate;
        try {
            testDate = format.parse(date);
            if (testDate.after(today)) {
                return testDate;
            }
            else {
                throw new IOException();
            }
        }
        catch (ParseException e) {
            throw e;
        }
    }
}
