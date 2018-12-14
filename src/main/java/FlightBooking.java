import FlightPojos.Fare;
import FlightPojos.FlightSearch;
import FlightPojos.Inbound;
import FlightPojos.Outbound;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.LowFareSearchResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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
        String currency = "USD";
        String travelClass = null;
        Integer number_of_results = 1;

        DefaultApi apiInstance = new DefaultApi();

        try {
            LowFareSearchResponse result = apiInstance.flightLowFareSearch(apiKey, origin, destination, departure_date, return_date, arrive_by, return_by, adults, children, infants, include_airlines, exclude_airlines, nonstop, max_price, currency, travelClass, number_of_results);

            Gson gson = new Gson();
            String jsonString = gson.toJson(result);
            JSONObject jsonObject = new JSONObject("results");
            ObjectMapper objectMapper = new ObjectMapper();

            JSONArray search = jsonObject.getJSONArray("results");

            JSONObject searchResults;
            JSONObject fare;
            JSONArray itineraries;
            JSONObject itineraryResults;
            JSONObject inbound;
            JSONObject outbound;

            List<String> flightsearch = new ArrayList<>();
            FlightSearch fly = objectMapper.readValue(jsonString, FlightSearch.class);
            fly.setCurrency(jsonObject.getString("currency"));

            for (int i = 0; i < search.length(); i++) {
                searchResults = search.getJSONObject(i);
                fare = searchResults.getJSONObject("fare");

                itineraries = searchResults.getJSONArray("itineraries");
                fly.setFare(objectMapper.readValue(String.valueOf(fare), Fare.class));
                for (int j = 0; j < itineraries.length(); j++ ){
                    itineraryResults = itineraries.getJSONObject(j);
                    outbound = itineraryResults.getJSONObject("outbound");
                    inbound = itineraryResults.getJSONObject("inbound");

                    fly.setOutbound(objectMapper.readValue(String.valueOf(outbound), Outbound.class));
                    fly.setInbound(objectMapper.readValue(String.valueOf(inbound), Inbound.class));
                    flightsearch.add(fly.toString());
                    System.out.println(flightsearch.get(j));
                }
            }
        }catch (ApiException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        catch (IOException e) {

        }



        return resultsMap;
    }
}
