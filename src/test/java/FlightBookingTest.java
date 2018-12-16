import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CarSearchResponse;
import models.carrental.Car;
import models.carrental.CarRentalSearch;
import models.carrental.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightBookingTest {
    @Test
    void receiveRequest() {
    }

    @DisplayName("Verify that we can successfully receive a nice string response")
    @Test
    void successfullyReturnStringItinerary() {
        DefaultApi apiInstance = new DefaultApiMock();
        String apiKey ="blah blah"
        String location = "JFK";
        String pickUp = "2018-12-22";
        String dropOff = "2018-12-23";
        String lang = null;
        String currency = null;
        String provider = null;
        String rateClass = null;
        String ratePlan = null;
        String rateFilter = null;
        List<String> vehicle = null;

        List<String> carRentalResults = new ArrayList<>();

        try {
            CarSearchResponse response = apiInstance.carRentalAirportSearch(apiKey, location, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicle);

            Gson gson = new Gson();
            String jsonString = gson.toJson(response);
            ObjectMapper objectMapper = new ObjectMapper();

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray search = jsonObject.getJSONArray("results");

            JSONObject searchResults;
            JSONArray cars;
            JSONObject carResults;

            CarRentalSearch drive = objectMapper.readValue(jsonString, CarRentalSearch.class);
            for (int i = 0; i < search.length(); i++) {
                searchResults = search.getJSONObject(i);
                drive.setResult(objectMapper.readValue(String.valueOf(searchResults), Result.class));
                cars = searchResults.getJSONArray("cars");
                for (int j = 0; j < cars.length(); j++) {
                    carResults = cars.getJSONObject(j);
                    drive.setCar(objectMapper.readValue(String.valueOf(carResults), Car.class));
                    carRentalResults.add(drive.toString());
                }
            }
        }catch (ApiException e) {

        }
        catch (IOException e) {

        }
    }
}