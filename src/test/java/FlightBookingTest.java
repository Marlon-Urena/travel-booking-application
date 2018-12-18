import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.LowFareSearchResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightBookingTest {
    @DisplayName("Test that exception will be thrown instead of itinerary being received")
    @Test
    void unsuccessfullyReceiveItinerary() {
        DefaultApi mockInstance = new FailingDefaultApiMock();
        Booking flightBooking = new FlightBooking(mockInstance);
        List<String> listOfNothing = new ArrayList<>();
        boolean exceptionThrown = false;

        for (int i = 0; i < 15; i++){
            listOfNothing.add(null);
        }
        try {
            flightBooking.provideOptions(listOfNothing);
        }
        catch (ApiException e) {
            exceptionThrown = true;
            assertTrue(exceptionThrown);
        }
        assertTrue(exceptionThrown);
    }

    @DisplayName("Test that itinerary will be returned")
    @Test
    void successfullyReceiveItinerary() {
    DefaultApi mockInstance = new WorkingDefaultApiMock();
    Booking flightBooking = new FlightBooking(mockInstance);
    List<String> listOfNothing = new ArrayList<>();
    boolean exceptionThrown = false;

    for (int i = 0; i < 15; i++){
        listOfNothing.add(null);
    }
    try {
        flightBooking.provideOptions(listOfNothing);
    }
    catch (ApiException e) {
            exceptionThrown = true;
            assertFalse(exceptionThrown);
    }
    assertFalse(exceptionThrown);
    }

    @DisplayName("Test that we will receive an exception from api")
    @Test
    void receiveExceptionFromApi() {
        boolean exceptionThrown = false;
        try {
            String apiKey = null;
            String origin = null;
            String destination = null;
            String departure_date = null;
            String return_date = null;
            String arrive_by = null;
            String return_by = null;
            Integer adults = null;
            Integer children = null;
            Integer infants = null;
            List<String> include_airlines = null;
            List<String> exclude_airlines = null;
            Boolean nonstop = null;
            Integer max_price = null;
            String currency = null;
            String travelClass = null;
            Integer number_of_results = null;
            DefaultApi mockInstance = new FailingDefaultApiMock();

            LowFareSearchResponse lowFareSearchResponse = mockInstance.flightLowFareSearch(apiKey, origin, destination, departure_date, return_date, arrive_by, return_by, adults, children, infants, include_airlines, exclude_airlines, nonstop, max_price, currency,travelClass,number_of_results);
        }catch (ApiException e) {
            exceptionThrown = true;
            assertTrue(exceptionThrown);
        }
        assertTrue(exceptionThrown);
    }

    @DisplayName("Test that we will receive a response from api")
    @Test
    void successfullyReceiveResponseFromApi() {
        boolean exceptionThrown = false;
        try {
            String apiKey = null;
            String origin = null;
            String destination = null;
            String departure_date = null;
            String return_date = null;
            String arrive_by = null;
            String return_by = null;
            Integer adults = null;
            Integer children = null;
            Integer infants = null;
            List<String> include_airlines = null;
            List<String> exclude_airlines = null;
            Boolean nonstop = null;
            Integer max_price = null;
            String currency = null;
            String travelClass = null;
            Integer number_of_results = null;
            DefaultApi mockInstance = new WorkingDefaultApiMock();

            LowFareSearchResponse lowFareSearchResponse = mockInstance.flightLowFareSearch(apiKey, origin, destination, departure_date, return_date, arrive_by, return_by, adults, children, infants, include_airlines, exclude_airlines, nonstop, max_price, currency,travelClass,number_of_results);
        }catch (ApiException e) {
            exceptionThrown = true;
            assertFalse(exceptionThrown);
        }
        assertFalse(exceptionThrown);
    }
}