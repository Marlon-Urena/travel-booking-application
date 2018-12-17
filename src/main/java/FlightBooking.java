import models.flight.Fare;
import models.flight.FlightSearch;
import models.flight.Inbound;
import models.flight.Outbound;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.LowFareSearchResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightBooking extends Booking{
    private DefaultApi apiInstance;

    private enum mealOption {
        VEGAN, BABY, KOSHER, LOW_SODIUM, NON_LACTOSE,
        DIABETIC, MUSLIM, CHILD, GLUTEN_FREE }

        private enum seatClass {
        ECONOMY, BUSINESS, FIRST_CLASS
        } //May have to rethink these enums based off the class of the seat

    public FlightBooking(DefaultApi apiInstance){
        this.apiInstance = apiInstance;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        List<Object> defaultParamsList = new ArrayList<>();
        String origin = String.valueOf(list.get(0));
        String destination = String.valueOf(list.get(1));
        String departure_date = String.valueOf(list.get(2));
        String return_date = String.valueOf(list.get(3));
        String arrive_by = null;
        String return_by = null;
        Integer adults = Integer.getInteger(list.get(6));
        Integer children = Integer.getInteger(list.get(7));
        Integer infants = Integer.getInteger(list.get(8));
        List<String> include_airlines = null;
        List<String> exclude_airlines = null;
        Boolean nonstop=  Boolean.getBoolean(list.get(11));
        Integer max_price = Integer.getInteger(list.get(12));
        String currency = null;
        String travelClass = list.get(14);
        Integer number_of_results = 1;

        List<Object> flightResults = new ArrayList<>();

        try {
            LowFareSearchResponse response = apiInstance.flightLowFareSearch(apiKey, origin, destination, departure_date, return_date, arrive_by, return_by, adults, children, infants, include_airlines, exclude_airlines, nonstop, max_price, currency, travelClass, number_of_results);

            Gson gson = new Gson();
            String jsonString = gson.toJson(response);
            JSONObject jsonObject = new JSONObject(jsonString);
            ObjectMapper objectMapper = new ObjectMapper();

            JSONArray search = jsonObject.getJSONArray("results");

            JSONObject searchResults;
            JSONObject fare;
            JSONArray itineraries;
            JSONObject itineraryResults;
            JSONObject inbound;
            JSONObject outbound;

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
                    flightResults.add(fly);
                }
            }
        }catch (ApiException e) {
            String responseString = e.getResponseBody();
            int beginLoc= responseString.indexOf("message")+12;
            int endLoc = responseString.indexOf("\"\n}");
            String exceptionErrorMessage = responseString.substring(beginLoc,endLoc);
            List<Object> exceptionMessage = new ArrayList<>();
            exceptionMessage.add(exceptionErrorMessage);
            return exceptionMessage;
        }
        catch (IOException e) {

        }

        return flightResults;
    }
}
