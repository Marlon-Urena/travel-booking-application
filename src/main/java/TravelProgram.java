public class TravelProgram {


    public static void main(String [] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        TravelProgram travelProgram = new TravelProgram();
        DataBase database = new DataBase();

        System.out.println("Welcome! Would you like to \n 1. Make a new account \n 2. Login");
        int response = scan.nextInt();

        System.out.println("Enter your email: ");
        String email = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();

        TravelerAccount travelAccount = new TravelerAccount(email, password);
        Traveler traveler = new Traveler();

        if(response == 1){
            travelProgram.createNewTravelerAccount(database, email);
        }
        else if(response == 2){
            travelAccount = travelAccount.login(database, email);
        }
    }

    public void makeNewBooking(Booking booking) {

    }

    public void displayFlightBookingMenu() {

    }

    public void displayCarRentalMenu() {

    }

    public void displayHotelBookingMenu() {

    }

    public void searchOldBooking() {

    }

    public boolean createNewTravelerAccount(String login) {

        return false;
    }
}
