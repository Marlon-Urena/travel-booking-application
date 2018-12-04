public class HotelBooking implements Booking {

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
    public void provideOptions() {

    }

}
