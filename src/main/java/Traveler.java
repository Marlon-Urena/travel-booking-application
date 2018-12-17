import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import static java.time.LocalDate.parse;

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

        public String getDestination() {
            return this.destination;
        }

        public void setTripDates(){
            Scanner scan = new Scanner(System.in);
            boolean validDates = false;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            System.out.println("What is the start and end date for your trip? Type dates in yyyy-MM-dd format.");
            do {
                System.out.print("Start date: ");
                String startDate = scan.nextLine();

                System.out.print("End date: ");
                String endDate = scan.nextLine();
                validDates = schedule.setDates(startDate, endDate);
            }while (!validDates);
        }

        public String makeRequest(Object booking, Database database) {
           return travelerAccount.saveBookingInformation(booking,database);

        }

        public boolean addActivityToSchedule(Activity activity, Estimate estimate){
            boolean isValid = false;
            LocalDate activityDate;

            System.out.print("Pick an Activity: ");
            activity.printActivityList();

            System.out.print("\nEnter your selection:");
            Scanner scan = new Scanner(System.in);
            int activityNumber = scan.nextInt();

            scan.nextLine();

            System.out.println("Enter the date for when you would like to do activity ");

            do {
                System.out.print("Date: ");
                String day = scan.nextLine();
                try {
                    activityDate = schedule.isDateValid(day);
                    isValid = true;
                    if(estimate.addToTotalCost(activity.getActivityPrice(activityNumber))) {
                        schedule.addActivityToSchedule(activityDate, activity.getActivity(activityNumber));
                        return true;
                    }
                }
                catch(DateTimeParseException e) {
                    System.out.println(day + "is invalid date format. Example: yyyy-MM-dd is valid date format.");
                }
                catch (IOException e) {
                    System.out.println(day + "is not a valid date. Please pick a date after today's date.");
                }
            }while(!isValid);


            return false;
        }

        public void setAccountInfo(TravelerAccount travelerAccount) {
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

            System.out.print("\tEnter your zip code: ");
            String zip = scan.nextLine();
            travelerAccount.setZipCode(zip);

            System.out.print("\tEnter you date of birth in yyyy-MM-dd format: ");
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dob = scan.nextLine();
                LocalDate dateOfBirth = parse(dob);
                travelerAccount.changeDateOfBirth(dateOfBirth);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date of birth.");
            }

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

        public Object retrieveBookingInfo(Database database, String bookingNumber) {

            return database.searchOldBookingData(bookingNumber);
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
