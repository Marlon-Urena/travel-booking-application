import java.util.ArrayList;
import java.util.List;

public class HotelBooking extends Booking {

    private Estimate estimate;
    private Schedule schedule;

    public HotelBooking(Estimate estimate, Schedule schedule){
        this.estimate= estimate;
        this.schedule= schedule;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {
        System.out.print("hey");
    }

    @Override
    public List<Object> provideOptions(List<String> list) {
        List<Object> object = new ArrayList<>();
        return object;
    }

}
