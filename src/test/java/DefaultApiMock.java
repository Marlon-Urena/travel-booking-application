import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import io.swagger.client.ApiException;
import io.swagger.client.model.CarSearchResponse;
import io.swagger.client.model.LowFareSearchResponse;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DefaultApiMock extends io.swagger.client.api.DefaultApi {
        @Override
        public CarSearchResponse carRentalAirportSearch(String apikey, String location, String pickUp, String dropOff, String lang, String currency, String provider, String rateClass, String ratePlan, String rateFilter, List<String> vehicle) throws ApiException {
            String responsePath = ("src" + File.separator + "main" + File.separator + "resources" + File.separator + "CarRentalSearchResponse.json");
            File file = new File(responsePath).getAbsoluteFile();
            try {
                JsonReader reader = new JsonReader(new FileReader(file));
                CarSearchResponse sampleResponse = new Gson().fromJson(reader, CarSearchResponse.class);
                return sampleResponse;
            }
            catch(IOException e) {

            }
              return null;
        }

        @Override
        public LowFareSearchResponse flightLowFareSearch(String apikey, String origin, String destination, String departureDate, String returnDate, String arriveBy, String returnBy, Integer adults, Integer children, Integer infants, List<String> includeAirlines, List<String> excludeAirlines, Boolean nonstop, Integer maxPrice, String currency, String travelClass, Integer numberOfResults) throws ApiException {
                String responsePath = ("src" + File.separator + "main" + File.separator + "resources" + File.separator + "LowFareSearchResponse.json");
                File file = new File(responsePath).getAbsoluteFile();
                try {
                    JsonReader reader = new JsonReader(new FileReader(file));
                    LowFareSearchResponse sampleResponse = new Gson().fromJson(reader, LowFareSearchResponse.class);
                    return sampleResponse;
                }
                catch(IOException e) {
                    System.out.println("FAILED");
                }
                return null;
        }

}
