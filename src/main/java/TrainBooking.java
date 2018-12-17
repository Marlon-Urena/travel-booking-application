import io.swagger.client.api.DefaultApi;

import java.util.ArrayList;
import java.util.List;

public class TrainBooking extends Booking{
    private DefaultApi apiInstance;
    public TrainBooking(DefaultApi apiInstance) {
    this.apiInstance = apiInstance;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        List<Object> object = new ArrayList<>();
        return null;
    }
}
