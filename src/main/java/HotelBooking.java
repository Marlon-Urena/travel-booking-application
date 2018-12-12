import java.util.List;
import java.util.Map;

public class HotelBooking extends Booking {

    private Estimate estimate;
    private Schedule schedule;

    public HotelBooking(Estimate estimate, Schedule schedule){
        this.estimate= estimate;
        this.schedule= schedule;
    }

    @Override
    public void receiveRequest() {

    }

    @Override
    public Map provideOptions(List<String> list) {

    }

}
