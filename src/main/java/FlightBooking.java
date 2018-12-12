import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.LowFareSearchResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightBooking extends Booking{
    private Estimate estimate;
    private Schedule schedule;

    private enum mealOption {
        VEGAN, BABY, KOSHER, LOW_SODIUM, NON_LACTOSE,
        DIABETIC, MUSLIM, CHILD, GLUTEN_FREE }

        private enum seatClass {
        ECONOMY, BUSINESS, FIRST_CLASS
        } //May have to rethink these enums based off the class of the seat

    public FlightBooking(Estimate estimate, Schedule schedule){
        this.estimate= estimate;
        this.schedule= schedule;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public Map provideOptions(List<String> list) {
        Map<String, String> resultsMap = new HashMap<>();
        String origin = null;
        String destination = null;
        String departure_date = null;
        String return_date = null;
        String arrive_by = null;
        String return_by =null;
        Integer adults = null;
        Integer children = null;
        Integer infants = null;
        List<String> include_airlines = null;
        List<String> exclude_airlines = null;
        Boolean nonstop= null;
        Integer max_price = null;
        String currency = null;
        String travelClass = null;
        Integer number_of_results = 5;

        for (int i = 0; i <list.size(); i++) {

        }

        DefaultApi apiInstance = new DefaultApi();
        try {
            LowFareSearchResponse result = apiInstance.flightLowFareSearch(apiKey, origin, destination, departure_date, return_date, arrive_by, return_by, adults, children, infants, include_airlines, exclude_airlines, nonstop, max_price, currency, travelClass, number_of_results);

            Gson gson = new Gson();
            String responseString = gson.toJson(result);


            Map<String, Object> map = new HashMap<>();


            JSONObject json = new JSONObject(responseString);
            JSONArray results = json.getJSONArray("results"); //Looking into how to get the map into the JSON object
            JSONObject results1 = results.getJSONObject(0); // Will be in for loop , may just have two results ex: fares
            JSONArray itineraries = results1.getJSONArray("itineraries"); //Has array of itineraries
            JSONObject itineraryResults = itineraries.getJSONObject(0); //Will be in for loop

            JSONObject inbound = itineraryResults.getJSONObject("inbound");
            JSONArray inboundFlights = inbound.getJSONArray("flights");
            JSONObject inboundFlightResults = inboundFlights.getJSONObject(0); //May need to iterate for 1<results, each will contain departs_by, arrives_by, flight_number, aircraft, operating_airline, marketing_airline. Will be in for loop
            JSONObject inboundBookingInfo = inboundFlightResults.getJSONObject("booking_info"); //Contains booking_code, travel class, and seats remaining
            JSONObject inboundOrigin = inboundFlightResults.getJSONObject("origin"); // Contains the outbound terminal number(or letter), airport initials
            JSONObject inboundDestination = inboundFlightResults.getJSONObject("destination"); // Contains the inbound terminal number(or letter), airport initials

            JSONObject outbound = itineraryResults.getJSONObject("outbound"); //contains duration
            JSONArray outboundFlights = outbound.getJSONArray("flights");
            JSONObject outboundFlightResults = outboundFlights.getJSONObject(0); //May need to iterate for 1<results, each will contain departs_by, arrives_by, flight_number, aircraft, operating_airline, marketing_airline. Will be in for loop
            JSONObject outboundBookingInfo = outboundFlightResults.getJSONObject("booking_info"); //Contains booking_code, travel class, and seats remaining
            JSONObject outboundOrigin = outboundFlightResults.getJSONObject("origin"); // Contains the outbound terminal number(or letter), airport initials
            JSONObject outboundDestination = outboundFlightResults.getJSONObject("destination"); // Contains the inbound terminal number(or letter), airport initials

            resultsMap.put("")
        }catch (ApiException e) {
            System.err.println(e);
            e.printStackTrace();
        }



        return resultsMap;
    }
}
