import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;
import io.swagger.client.ApiException;
import io.swagger.client.model.CarSearchResponse;
import io.swagger.client.model.LowFareSearchResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DefaultApiMock extends io.swagger.client.api.DefaultApi {
        @Override
        public CarSearchResponse carRentalAirportSearch(String apikey, String location, String pickUp, String dropOff, String lang, String currency, String provider, String rateClass, String ratePlan, String rateFilter, List<String> vehicle) throws ApiException {
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("CarRentalSearchResponse.json").getFile());
                try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        return objectMapper.readValue(file, CarSearchResponse.class);
                }
                catch(IOException e) {

                }
                CarSearchResponse response = new CarSearchResponse();
              return response;
        }

        @Override
        public LowFareSearchResponse flightLowFareSearch(String apikey, String origin, String destination, String departureDate, String returnDate, String arriveBy, String returnBy, Integer adults, Integer children, Integer infants, List<String> includeAirlines, List<String> excludeAirlines, Boolean nonstop, Integer maxPrice, String currency, String travelClass, Integer numberOfResults) throws ApiException {
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("LowFareSearchResponse.json").getFile());
                try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        return objectMapper.readValue(file, LowFareSearchResponse.class);
                }
                catch(IOException e) {

                }
                LowFareSearchResponse response = new LowFareSearchResponse();
                return response;
        }
        }
}
