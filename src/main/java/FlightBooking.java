public class FlightBooking extends Booking{
    private Estimate estimate;
    private Schedule schedule;

    private enum mealOption {
        VEGAN, BABY, KOSHER, LOW_SODIUM, NON_LACTOSE,
        DIABETIC, MUSLIM, CHILD, GLUTEN_FREE }

        private enum seatClass {
        ECONOMY, BUSINESS, FIRST_CLASS
        } //May have to rethink these enums based off the class of the seat

    public FlightBooking(Estimate estimate, Schedule schedule){
        this.estimate= estimate;
        this.schedule= schedule;
    }

    @Override
    public void receiveRequest(Estimate estimate, Schedule schedule) {

    }

    @Override
    public void provideOptions() {

    }
}
