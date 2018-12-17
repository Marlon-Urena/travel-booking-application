import io.swagger.client.api.DefaultApi;

import java.util.ArrayList;
import java.util.List;

public class HotelBooking extends Booking {

    private DefaultApi apiInstance;

    public HotelBooking(DefaultApi apiInstance){
        this.apiInstance = apiInstance;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {
        System.out.print("hey");
    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        List<Object> object = new ArrayList<>();
        return null;
    }

}
