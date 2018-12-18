import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CarSearchResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarRentalBookingTest extends io.swagger.client.api.DefaultApi{
    @DisplayName("Test that exception will be thrown instead of options being received")
    @Test
    void unsuccessfullyReceiveItinerary() {
        DefaultApi mockInstance = new FailingDefaultApiMock();
        Booking carRentalBooking = new CarRentalBooking(mockInstance);
        List<String> listOfNothing = new ArrayList<>();
        boolean exceptionThrown = false;

        for (int i = 0; i < 9; i++){
            listOfNothing.add(null);
        }
        try {
            carRentalBooking.provideOptions(listOfNothing);
        }
        catch (ApiException e) {
            exceptionThrown = true;
            assertTrue(exceptionThrown);
        }
        assertTrue(exceptionThrown);
    }

    @DisplayName("Test that car rental options will be returned")
    @Test
    void successfullyReceiveItinerary() {
        DefaultApi mockInstance = new WorkingDefaultApiMock();
        Booking carRentalBooking = new CarRentalBooking(mockInstance);
        List<String> listOfNothing = new ArrayList<>();
        boolean exceptionThrown = false;

        for (int i = 0; i < 15; i++){
            listOfNothing.add(null);
        }
        try {
            carRentalBooking.provideOptions(listOfNothing);
        }
        catch (ApiException e) {
            exceptionThrown = true;
            assertFalse(exceptionThrown);
        }
        assertFalse(exceptionThrown);
    }
    @DisplayName("Verify that we will receive an exception")
    @Test
    void receiveExceptionFromApi() {
        boolean exceptionThrown = false;
        try {
            String apiKey = null;
            String location = null;
            String pickUp = null;
            String dropOff = null;
            String lang = null;
            String currency = null;
            String provider = null;
            String rateClass = null;
            String ratePlan = null;
            String rateFilter = null;
            List<String> vehicle = null;
            DefaultApi mockInstance = new FailingDefaultApiMock();
            CarSearchResponse carSearchResponse = mockInstance.carRentalAirportSearch(apiKey, location, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicle);
        } catch(ApiException e) {
            exceptionThrown = true;
            assertTrue(exceptionThrown);
        }
        assertTrue(exceptionThrown);
    }

    @DisplayName ("Verify that we are receiving a response from api")
    @Test
    void successfullyReceiveResponseFromApi() {
        boolean exceptionThrown = false;
        try {

            String apiKey = null;
            String location = null;
            String pickUp = null;
            String dropOff = null;
            String lang = null;
            String currency = null;
            String provider = null;
            String rateClass = null;
            String ratePlan = null;
            String rateFilter = null;
            List<String> vehicle = null;
            DefaultApi mockInstance = new WorkingDefaultApiMock();
            CarSearchResponse carSearchResponse = mockInstance.carRentalAirportSearch(apiKey, location, pickUp, dropOff, lang, currency, provider, rateClass, ratePlan, rateFilter, vehicle);

        }catch (ApiException e) {
            exceptionThrown = true;
            assertFalse(exceptionThrown);
        }
        assertFalse(exceptionThrown);
    }
}