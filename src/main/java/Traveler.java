import java.text.ParseException;
import java.util.Scanner;

    public class Traveler {
        private TravelerAccount travelerAccount;
        private Budget budget;
        private Schedule schedule;
        private String Login;
        private Database database;
        private String destination;
        private int lengthOfTrip;


        public Traveler(Schedule schedule, Budget budget){
            this.schedule = schedule;
            this.budget = budget;
        }

        public void setBudget(double travelBudget){
            budget.setTravelerBudget(travelBudget);
        }

        public void setDestination(){
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your destination: ");
            this.destination = scan.nextLine();
        }

        public void setLengthOfTrip(){
            Scanner scan = new Scanner(System.in);
            System.out.println("How long would you like the trip to last? ");
            this.lengthOfTrip = scan.nextInt();
            schedule.setLengthOfTrip(lengthOfTrip);
        }

        public void makeRequest(Booking booking) {
            setDestination();
            setLengthOfTrip();

            //implementation
        }

        public boolean addActivityToSchedule(Activity activity, Estimate estimate){
            System.out.print("Pick an Activity: ");
            activity.printActivityList();

            System.out.print("\nEnter your selection:");
            Scanner scan = new Scanner(System.in);
            int activityNumber = scan.nextInt();

            System.out.print("Enter the number day you would like to do activty: ");
            int day = scan.nextInt();

            scan.nextLine();

            if(estimate.addToTotalCost(activity.getActivityPrice(activityNumber))) {
                schedule.addActivityToSchedule(day, activity.getActivity(activityNumber));
                return true;
            }

            return false;
        }

        public void setAccountInfo(TravelerAccount travelerAccount) throws ParseException {
            Scanner scan = new Scanner(System.in);
            System.out.println("*********************");
            System.out.println("Enter Account Info");
            System.out.println("*********************");

            System.out.print("\tEnter your first name: ");
            String firstName = scan.nextLine();
            travelerAccount.setFirstName(firstName);

            System.out.print("\tEnter your last name: ");
            String lastName = scan.nextLine();
            travelerAccount.setLastName(lastName);

            System.out.print("\tEnter your address: ");
            String address = scan.nextLine();
            travelerAccount.setAddressLine1(address);

            System.out.print("\tEnter your city: ");
            String city = scan.nextLine();
            travelerAccount.setCity(city);

            System.out.print("\tEnter your state: ");
            String state = scan.nextLine();
            travelerAccount.setState(state);

            System.out.print("\tEnter your ZIP Code: ");
            String zip = scan.nextLine();
            travelerAccount.setZipCode(zip);

        }

        public void changeAccountInfo(TravelerAccount travelerAccount) throws ParseException {
            Scanner scan = new Scanner(System.in);
            System.out.println("Would you like to change your 1) email 2) password 3) Go back");
            int response = scan.nextInt();

            if(response == 1){
                System.out.println("Enter new email: ");
                String newEmail = scan.next();
                travelerAccount.changeEmail(newEmail);
            }
            else if(response  == 2){
                System.out.println("Enter new password: ");
                String newPassword = scan.next();
                travelerAccount.changePassword(newPassword);
            }
        }

        public void retrieveBookingInfo(Database database, String bookingNumber) {
            database.searchOldBookingData(bookingNumber);
        }

        public boolean login(TravelerAccount travelerAccount) {
            if(travelerAccount == null) {
                this.travelerAccount = travelerAccount;
                return false;
            }
            else {
                this.travelerAccount = travelerAccount;
                return true;
            }
        }
        public void logOut() {
            this.travelerAccount = null;
        }

}
