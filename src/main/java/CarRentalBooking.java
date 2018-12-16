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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRentalBooking extends Booking{

    public CarRentalBooking(Estimate estimate, Schedule schedule) {

    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        String location = list.get(0);
        String pickUp = list.get(1);
        String dropOff = list.get(2);
        String lang = null;
        String currency = null;
        String provider = null;
        String rateClass = null;
        String ratePlan = null;
        String rateFilter = null;
        List<String> vehicle = null;

        List<Object> carRentalResults = new ArrayList<>();

        DefaultApi apiInstance = new DefaultApi();

        try {
            CarSearchResponse response = apiInstance.carRentalAirportSearch(apiKey,location, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicle);

            Gson gson = new Gson();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = gson.toJson(response);

            JSONObject jsonObject = new JSONObject("results");
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
                    carRentalResults.add(drive);
                }
            }
        }
        catch (ApiException e) {
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
        return carRentalResults;
    }
}
