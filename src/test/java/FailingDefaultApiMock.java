import io.swagger.client.ApiException;
import io.swagger.client.model.CarSearchResponse;
import io.swagger.client.model.LowFareSearchResponse;
import java.util.List;

public class FailingDefaultApiMock extends io.swagger.client.api.DefaultApi{
    @Override
    public CarSearchResponse carRentalAirportSearch(String apikey, String location, String pickUp, String dropOff, String lang, String currency, String provider, String rateClass, String ratePlan, String rateFilter, List<String> vehicle) throws ApiException {
        throw new ApiException();
    }

    @Override
    public LowFareSearchResponse flightLowFareSearch(String apikey, String origin, String destination, String departureDate, String returnDate, String arriveBy, String returnBy, Integer adults, Integer children, Integer infants, List<String> includeAirlines, List<String> excludeAirlines, Boolean nonstop, Integer maxPrice, String currency, String travelClass, Integer numberOfResults) throws ApiException {
       throw new ApiException();
    }
}
