import java.util.HashMap;
import java.util.Map;

public class Activity {
    private Map<String, Double> activityPriceMap = new HashMap<>();
    private Map<Integer, String> activityMap = new HashMap<>();


    public void addToActivityPriceMap(){
       activityPriceMap.put("Skydiving", Double.valueOf(300));
       activityPriceMap.put("Museum Visit", Double.valueOf(20));
       activityPriceMap.put("Horseback Riding", Double.valueOf(60));
       activityPriceMap.put("Surfing Lessons", Double.valueOf(50));
       activityPriceMap.put("Spa", Double.valueOf(100));
       activityPriceMap.put("Amusement Park", Double.valueOf(75));
    }

    public void addToActivityMap(){
        activityMap.put(1, "Skydiving");
        activityMap.put(2, "Museum Visit");
        activityMap.put(3, "Horseback Riding");
        activityMap.put(4, "Surfing Lessons");
        activityMap.put(5, "Spa");
        activityMap.put(6, "Amusement Park");
    }

    public String getActivity(int activityNumber){
        return activityMap.get(activityNumber);
    }

    public double getActivityPrice(int activityNumber){
        String activity = getActivity(activityNumber);
        return activityPriceMap.get(activity);
    }

    public void printActivityList(){
        for(int i = 1; i <= activityMap.size(); i++){
            System.out.print("\t"+i + ". ");
            String s = activityMap.get(i);
            System.out.print(s + " = $" + activityPriceMap.get(s));
        }
    }
}
