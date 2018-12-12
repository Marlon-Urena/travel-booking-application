import org.apache.commons.validator.routines.EmailValidator;

import java.util.*;

public class TravelProgram {
    private static final int FLIGHT_BOOKING = 1;
    private static final int CAR_RENTAL_BOOKING = 2;
    private static final int HOTEL_BOOKING = 3;
    private static final int TRAIN_BOOKING = 4;
    private static final int SEARCH_OLD_BOOKING = 5;
    private static final int CHANGE_ACCOUNT_INFORMATION = 6;
    private static final int LOGOUT = 7;
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
                        displayFlightBookingMenu(scanner, traveler, flightBooking);
                        break;
                    case CAR_RENTAL_BOOKING:
                        displayCarRentalMenu(scanner, traveler, carRentalBooking);
                        break;
                    case HOTEL_BOOKING:
                        displayHotelBookingMenu(scanner, traveler, hotelBooking);
                        break;
                    case TRAIN_BOOKING:
                        displayTrainBookingMenu(scanner, traveler, trainBooking);
                        break;
                    case SEARCH_OLD_BOOKING:
                        displayTravelerBookingSearchMenu(scanner, traveler);
                        break;
                    case CHANGE_ACCOUNT_INFORMATION:
                        displayAccountInformationMenu(scanner, traveler);
                        break;
                    case LOGOUT:
                        signedIn= traveler.logout();

                    default:
                        selection = EXIT;
                }
            } while (selection != EXIT);
    }
    public static int displayMenu(Scanner scanner) {
        System.out.println("**********************************");
        System.out.println("MENU: ");
        System.out.println("\t1. Search flights");
        System.out.println("\t2. Search car rentals");
        System.out.println("\t3. Search hotels");
        System.out.println("\t4. Search trains");
        System.out.println("\t5. Search previous bookings");
        System.out.println("\t6. Change account information");
        System.out.println("\t7. Logout");
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

    public static void displayFlightBookingMenu(Scanner scanner, Traveler traveler, Booking flight) {
        System.out.println("*********************");
        System.out.println("Flight Search");
        System.out.println("*********************");
        System.out.println();
        List<String> searchParams = new ArrayList<>();
        Map<String, Object> flightOptions = new HashMap<>();

        System.out.println("Enter search parameters below. Leave unwanted parameters blank.");
        System.out.print("(Required) Travel from: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Required) Travel to: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Required) Departure date: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Return date: ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        searchParams.add(null);
        System.out.print("(Optional) Number of adults: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of children: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of infants: ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        searchParams.add(null);
        System.out.print("(Optional) Nonstop (y or n): ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Max price: ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        System.out.print("(Optional) Travel Class (ECONOMY, PREMIUM ECONOMY, BUSINESS, FIRST): ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of results to display: ");
        searchParams.add(scanner.nextLine());
        flightOptions = flight.provideOptions(searchParams);


    }

    public static void displayCarRentalMenu(Scanner scanner, Traveler traveler, Booking carRentalBooking) {
        System.out.println("*********************");
        System.out.println("Car Rental Search");
        System.out.println("*********************");
        System.out.println();

        System.out.println();
    }

    public static void displayHotelBookingMenu(Scanner scanner, Traveler traveler, Booking hotelBooking) {
        System.out.println("*********************");
        System.out.println("Hotel Search");
        System.out.println("*********************");
        System.out.println();

        System.out.println();
    }

    public static void displayTrainBookingMenu(Scanner scanner, Traveler traveler, Booking trainBooking) {
        System.out.println("*********************");
        System.out.println("Train Search");
        System.out.println("*********************");
        System.out.println();

        System.out.println();
    }

    public static void displayTravelerBookingSearchMenu(Scanner scannner, Traveler traveler) {

    }

    public static void displayAccountInformationMenu(Scanner scanner, Traveler traveler) {

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
                System.out.println("\t"+e); //May remove Exceptions and just have a boolean returned
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
