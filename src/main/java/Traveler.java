import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

    public class Traveler {
        private TravelerAccount travelerAccount;
        private Schedule schedule;
        private String Login;
        private Database database;

        public void makeRequest(Booking booking) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your destination: ");
            String destination = scan.next();

            //Find Flight info based on the destination

            System.out.println("How long would you like the trip to last? ");
            int lengthOfTrip = scan.nextInt();
            schedule.setLengthOfTrip(lengthOfTrip);
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

            /*System.out.println("\tEnter your date of Birth: ");
            String dateOfBirth = scan.next();
            DateFormat formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
            Date date = formatter.parse(dateOfBirth);
            travelerAccount.setDateOfBirth(date);*/

        }

        public void changeAccountInfo(TravelerAccount travelerAccount) throws ParseException {
            Scanner scan = new Scanner(System.in);
            System.out.println("Would you like to change your 1) email 2) password 3)date of birth 4) Go back");
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
            else if(response == 3){
                System.out.println("Enter new date of birth: ");
                String newDate = scan.next();
                DateFormat formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
                Date date = formatter.parse(newDate);
                travelerAccount.changeDateOfBirth(date);
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
