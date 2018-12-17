import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.CarSearchResponse;
import models.carrental.Car;
import models.carrental.CarRentalSearch;
import models.carrental.Result;
import models.flight.FlightSearch;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalBookingTest extends io.swagger.client.api.DefaultApi{

    @Test
    void receiveRequest() {
    }

    @DisplayName ("Verify that we are receiving a nice string response")
    @Test
    void provideOptions() {
        try {
            DefaultApi mockInstance = new DefaultApiMock();
            Booking carRentalBooking = new CarRentalBooking(mockInstance);

            List<String> listOfNothing = new ArrayList<>();
            for (int i = 0; i < 9; i++)
                listOfNothing.add(null);

            List<Object> listOfOptions = carRentalBooking.provideOptions(listOfNothing);

            String firstStringPath = ("src" + File.separator + "main" + File.separator + "resources" + File.separator + "CarRentalSearchString");
            File file1 = new File(firstStringPath).getAbsoluteFile();

            String secondStringPath = ("src" + File.separator + "main" + File.separator + "resources" + File.separator + "CarRentalSearchString(1)");
            File file2 = new File(secondStringPath).getAbsoluteFile();

            boolean successful = false;

            ObjectMapper objectMapper = new ObjectMapper();
            CarRentalSearch searchString = objectMapper.readValue(file1, CarRentalSearch.class);
            assertEquals(searchString, listOfOptions.get(0));

            searchString = objectMapper.readValue(file2, CarRentalSearch.class);
            assertEquals(searchString, listOfOptions.get(1));

        }catch (ApiException e) {
        }
        catch (IOException e) {
        }
    }
}