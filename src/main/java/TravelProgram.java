import org.apache.commons.validator.routines.EmailValidator;

import java.util.Scanner;

public class TravelProgram {
    private static final int FLIGHT_BOOKING = 1;
    private static final int CAR_RENTAL_BOOKING = 2;
    private static final int HOTEL_BOOKING = 3;
    private static final int TRAIN_BOOKING = 4;
    private static final int SEARCH_OLD_BOOKING = 5;
    private static final int CHANGE_ACCOUNT_INFORMATION = 6;
    private static final int LOG_OUT = 7;
    private static final int EXIT = 8;

    public static void main(String [] args) {
        Traveler traveler= new Traveler();
        TravelerAccount travelerAccount=null;
        Database database= new Database();

        Schedule schedule = new Schedule();
        Estimate estimate = new Estimate();

        Booking flightBooking = new FlightBooking(estimate, schedule);
        Booking hotelBooking = new HotelBooking(estimate, schedule);
        Booking carRentalBooking = new CarRentalBooking(estimate, schedule);
        Booking trainBooking = new TrainBooking(estimate, schedule);
        boolean signedIn = false;

        Scanner scanner = new Scanner(System.in);

            int selection;
            do {
                while (!signedIn) {

                    System.out.println("Would you like to \n 1. Make a new Account \n 2. Login ");
                    selection = scanner.nextInt();

                    if (selection == 1) {
                        traveler.login(loginToTravelerAccount(travelerAccount, database, scanner));
                        signedIn = true;
                    }
                    else if (selection == 2) {
                        createNewTravelerAccount(travelerAccount,database, scanner);
                    }
                }

                selection = displayMenu(scanner);

                switch (selection) { //May change listing to just have makeBooking call the booking types
                    case FLIGHT_BOOKING:
                        displayFlightBookingMenu(scanner, traveler);
                        break;
                    case CAR_RENTAL_BOOKING:
                        displayCarRentalMenu(scanner, traveler);
                        break;
                    case HOTEL_BOOKING:
                        displayHotelBookingMenu(scanner, traveler);
                        break;
                    case TRAIN_BOOKING:
                        displayTrainBookingMenu(scanner, traveler);
                        break;
                    case SEARCH_OLD_BOOKING:
                        displayTravelerBookingSearchMenu(scanner, traveler);
                        break;
                    case CHANGE_ACCOUNT_INFORMATION:
                        displayAccountInformationMenu(scanner, traveler);
                        break;
                    case LOG_OUT:
                        traveler= logOut();

                    default:
                        selection = EXIT;
                }
            } while (selection != EXIT);
    }
    public static int displayMenu(Scanner scanner) {
        System.out.println("**********************************");
        System.out.println("MENU: ");
        System.out.println("\t1. Add a new word/definition");
        System.out.println("\t2. Get a definition");
        System.out.println("\t3. Get the entry count");
        System.out.println("\t4. Load the dictionary file");
        System.out.println("\t5. Save the dictionary file");
        System.out.println("\t6. Quit");
        System.out.println("**********************************");
        System.out.print("\nEnter your selection: ");

        int selection;

        try {
            selection = scanner.nextInt();
        }
        catch(Exception e){
            selection = EXIT;
        }

        scanner.nextLine(); // Clear the input buffer of the extra new line
        System.out.println();

        return selection;
    }
    public static void makeNewBooking(Booking booking) {

    }

    public static void displayFlightBookingMenu(Scanner scanner, Traveler traveler) {

    }

    public static void displayCarRentalMenu(Scanner scanner, Traveler traveler) {

    }

    public static void displayHotelBookingMenu(Scanner scanner, Traveler traveler) {

    }

    public static void displayTrainBookingMenu(Scanner scanner, Traveler traveler) {

    }

    public static void displayTravelerBookingSearchMenu(Scanner scannner, Traveler traveler) {

    }

    public static void displayAccountInformationMenu(Scanner scanner, Traveler traveler) {

    }

    public static Traveler logOut() {
        return null;
    }


    public static TravelerAccount loginToTravelerAccount(TravelerAccount travelerAccount, Database database, Scanner scanner) {
        String email;
        String password;

        boolean validEntry =false;

        System.out.println("*********************");
        System.out.println("Login");
        System.out.println("*********************");
        System.out.println();
        do {
            System.out.print("\tEmail: ");
            email = scanner.nextLine();

            System.out.println();

            System.out.print("\tPassword: ");
            password = scanner.nextLine();

            System.out.println();
            try {
                travelerAccount = travelerAccount.login(database,email, password);
                validEntry = true;
            } catch (RuntimeException e) {
                System.out.println("\t"+e);
            } catch (Exception e) {
                System.out.println("\t"+ e);
            }
        }while(!validEntry);
        return travelerAccount;
    }

    public static void createNewTravelerAccount(TravelerAccount travelerAccount, Database database, Scanner scanner) {
        String email;
        String password;
        String confirmationPassword;
        boolean validAccountDetails = false;
        do {
            System.out.println("*********************");
            System.out.println("Create Account");
            System.out.println("*********************");

            System.out.println("\tEnter email and password below");
            System.out.print("\tEmail: ");
            email = scanner.nextLine();

            System.out.print("\tPassword: ");
            password = scanner.nextLine();

            System .out.print("\tConfirm Password: "); //May remove
            confirmationPassword = scanner.nextLine();

            if(password.equals(confirmationPassword)) {
                if (validAccountDetails = travelerAccount.createNewTravelerAccount(travelerAccount, database, email, password)) {
                    System.out.println("\tSuccess");
                }
            }
            else {
                System.out.println ("Password does not match. Please try again");
            }
        }while(!validAccountDetails);
    }
}
