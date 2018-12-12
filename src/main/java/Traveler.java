import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

    public class Traveler {
        private TravelerAccount travelerAccount;
        private Schedule schedule;
        private String Login;

        public void makeRequest(Booking booking) {
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your destination: ");
            String destination = scan.next();

            //Find Flight info based on the destination

            System.out.println("How long would you like the trip to last? ");
            int lengthOfTrip = scan.nextInt();
            schedule.setLengthOfTrip(lengthOfTrip);
        }

        public void changeAccountInfo() throws ParseException {
            Scanner scan = new Scanner(System.in);
            System.out.println("Would you like to change your 1) email 2) password 3)date of birth ");
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
                travelerAccount.changedateOfBirth(date);
            }
            else{
                //quit
            }
        }

        public void retrieveBookingInfo() {
            //input booking number to database
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

        public boolean logout() {
            this.travelerAccount = null;
            return true;
        }

}
