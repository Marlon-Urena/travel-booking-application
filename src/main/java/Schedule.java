import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private int lengthOfTrip;

    Map<Integer, String> scheduleMap = new HashMap<>();

    public void setLengthOfTrip(int length){
        lengthOfTrip = length;
    }

    public int getLengthOfTrip(){
        return lengthOfTrip;
    }

    public void addActivityToSchedule(Integer date, String activity){
        scheduleMap.put(date, activity);
    }

    public void printSchedule(){
        System.out.print(scheduleMap);
    }
}
