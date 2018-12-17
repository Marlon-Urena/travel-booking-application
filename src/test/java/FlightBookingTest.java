import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.LowFareSearchResponse;

import models.flight.Fare;
import models.flight.FlightSearch;
import models.flight.Inbound;
import models.flight.Outbound;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
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
            DefaultApi mockInstance = new DefaultApiMock();
            Booking flightBooking = new FlightBooking(mockInstance);

            List<String> listOfNothing = new ArrayList<>();
            for (int i = 0; i < 15; i++)
                listOfNothing.add(null);

            List<Object> listOfOptions = flightBooking.provideOptions(listOfNothing);

            String responsePath = ("src" + File.separator + "main" + File.separator + "resources" + File.separator + "LowFareSearchString");
            File file = new File(responsePath).getAbsoluteFile();
            boolean successful = false;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                FlightSearch searchString = objectMapper.readValue(file, FlightSearch.class);
                assertEquals(searchString, listOfOptions.get(0));

            }
            catch (IOException e) {
                successful = false;
            }



    }
}