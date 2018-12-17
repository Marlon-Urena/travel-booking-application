import java.util.ArrayList;
import java.util.List;

public class TrainBooking extends Booking{
    public TrainBooking() {

    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        List<Object> object = new ArrayList<>();
        return object;
    }
}
