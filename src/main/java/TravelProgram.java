import org.apache.commons.validator.routines.EmailValidator;

import java.awt.print.Book;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelProgram{
    private static final int CREATE_BOOKING = 1;
    private static final int SEARCH_BOOKING = 2;
    private static final int CHANGE_INFO = 3;
    private static final int LOG_OUT = 4;
    private static final int EXIT = 4;

    public static void main(String [] args) throws ParseException {
        TravelerAccount travelerAccount = null;
        Database database= new Database();

        Schedule schedule = new Schedule();

        Budget budget = new Budget();
        Estimate estimate = new Estimate(budget);
        Activity activity = new Activity();
        Traveler traveler = new Traveler(schedule, budget);

        Booking flightBooking = new FlightBooking(estimate, schedule);
        //Booking hotelBooking = new HotelBooking();
        Booking carRentalBooking = new CarRentalBooking(estimate, schedule);
        //Booking trainBooking = new TrainBooking();
        List<Booking> bookingOptions = new ArrayList<>();

        bookingOptions.add(flightBooking);
        bookingOptions.add(carRentalBooking);

        boolean signedIn = false;

        Scanner scanner = new Scanner(System.in);

            int selection;
            System.out.println("Hello! \nWould you like to \n 1. Login \n 2. Make a new account ");
            selection = scanner.nextInt();
            scanner.nextLine();
            do {
                while (!signedIn) {

                    if (selection == 1) {
                        traveler.login(loginToTravelerAccount(travelerAccount, database, scanner));
                        signedIn = true;
                    } else if (selection == 2) {
                        travelerAccount = createNewTravelerAccount(travelerAccount, database, scanner);
                        traveler.setAccountInfo(travelerAccount);
                        traveler.login(loginToTravelerAccount(travelerAccount, database, scanner));
                        signedIn = true;
                    }
                }

                selection = displayMenu(scanner);

                switch (selection) {
                    case CREATE_BOOKING:{
                        System.out.print("Set budget for your trip: ");
                        double tripBudget = scanner.nextDouble();
                        traveler.setBudget(tripBudget);

                        displayBookingMenu(scanner, database, traveler, bookingOptions, estimate, activity); //Only passing flightBooking but what about carRentalBooking and the other bookings?
                    }

                        break;
                    case SEARCH_BOOKING:{
                        System.out.println("Enter booking number: ");
                        String bookingNum = scanner.nextLine();
                        traveler.retrieveBookingInfo(database, bookingNum);
                    }
                        break;
                    case CHANGE_INFO:
                        traveler.changeAccountInfo(travelerAccount);
                        break;
                    case LOG_OUT: {
                        traveler = logOut();
                    }
                    default:
                        selection = EXIT;
                }
            } while (selection != EXIT);
    }

    public static int displayMenu(Scanner scanner) {
        System.out.println("**********************************");
        System.out.println("MAIN MENU: ");
        System.out.println("\t1. Create a new Booking");
        System.out.println("\t2. Search an old Booking");
        System.out.println("\t3. Change account Info");
        System.out.println("\t4. Log Out");
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
    public static void makeNewBooking(Traveler traveler, Object booking) {

    }

    public static void displayBookingMenu(Scanner scanner, Database database, Traveler traveler, List<Booking> bookingOptions, Estimate estimate, Activity activity){
        boolean EXIT = false; 
        do {
            System.out.println("*********************");
            System.out.println("BOOKING MENU: ");
            System.out.println("*********************");

            System.out.println("\t1. Book a flight");
            System.out.println("\t2. Rent a car");
            System.out.println("\t3. Book a hotel");
            System.out.println("\t4. Book a train ticket");
            System.out.println("\t5. Add activity to schedule");
            System.out.println("\t6. Estimate trip cost");
            System.out.println("\t7. Back to Main Menu");
            System.out.print("\nEnter your selection:");
            
            int response = scanner.nextInt();
            
            if(response == 1){displayFlightBookingMenu(scanner, database, traveler, bookingOptions.get(response-1));}
            else if(response == 2){displayCarRentalMenu(scanner, database,  traveler, bookingOptions.get(response-1));}
            else if(response == 3){}
            else if(response == 4){}
            else if(response == 5){traveler.addActivityToSchedule(activity, estimate);}
            else if(response == 6){System.out.println(estimate.provideEstimate());}
            else if(response == 7){EXIT = true;}
            else
                System.out.println("Error: try again");

        }while(!EXIT);
        
    }
    public static void displayFlightBookingMenu(Scanner scanner, Database database,  Traveler traveler, Booking flightBooking) {
        System.out.println("*********************");
        System.out.println("Flight Search");
        System.out.println("*********************");
        System.out.println();
        List<String> searchParams = new ArrayList<>();
        List <Object> flightOptions;
        int selection;

        System.out.println("Enter search parameters below. Leave unwanted parameters blank.");
        System.out.print("(Required) Travel from: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Required) Travel to: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Required) Departure date (YYYY-MM-DD): ");
        searchParams.add(scanner.nextLine());


        System.out.print("(Optional) Return date (YYYY-MM-DD): ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        searchParams.add(null);
        System.out.print("(Required) Number of adults: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of children: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of infants: ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        searchParams.add(null);
        System.out.print("(Optional) Nonstop (true or false): ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Max price: ");
        searchParams.add(scanner.nextLine());
        searchParams.add(null);
        System.out.print("(Optional) Travel Class (ECONOMY, PREMIUM ECONOMY, BUSINESS, FIRST): ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Optional) Number of results to display: ");
        searchParams.add(scanner.nextLine());

        flightOptions = flightBooking.provideOptions(searchParams);
        for (int i = 0; i < flightOptions.size(); i++) {
            System.out.println("Itinerary #" + i+1);
            System.out.println(flightOptions.get(i));
        }
        System.out.println("Enter the number next to your desired itinerary: ");
        selection = scanner.nextInt();
        traveler.makeRequest(flightOptions.get(selection), database);
        scanner.nextLine();

        //traveler.makeRequest(flightOptions.get(selection-1)); //Will request the selected booking but will check to see if it fits within Traveler's budget


    }

    public static void displayCarRentalMenu(Scanner scanner, Database database, Traveler traveler, Booking carRentalBooking) {
        System.out.println("*********************");
        System.out.println("Car Rental Search");
        System.out.println("*********************");
        System.out.println();
        List<String> searchParams = new ArrayList<>();
        List<Object> carRentalOptions;
        int selection;

        System.out.print("(Required) Enter airport you would like to pick up car from: ");
        searchParams.add(scanner.nextLine());
        System.out.print("(Required) Enter pick up date in YYYY-MM-DDThh:mm format, time is optional: ");
        searchParams.add(scanner.nextLine());
        System.out.print("{Required) Enter drop off date in YYYY-MM-DDThh:mm format, time is optional:");
        searchParams.add(scanner.nextLine());
        //System.out.print("(Optional) Enter your 2 character country code (e.g. US,FR,IT): ");
        //searchParams.add(scanner.nextLine());
        carRentalOptions = carRentalBooking.provideOptions(searchParams);

        for(int i = 0; i < carRentalOptions.size(); i++) {
            System.out.println("Option #" + i+1);
            System.out.println(carRentalOptions.get(i));
        }
        System.out.println("Enter the number next to your desired option: ");
        selection = scanner.nextInt();
        traveler.makeRequest(carRentalOptions.get(selection), database);
        scanner.nextLine();


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

        System.out.println("\n*********************");
        System.out.println("Login");
        System.out.println("*********************");
        System.out.println();
        do {
            System.out.print("\tEmail: ");
            email = scanner.nextLine();

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

    public static TravelerAccount createNewTravelerAccount(TravelerAccount travelerAccount, Database database, Scanner scanner) {
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
                if (validAccountDetails = travelerAccount.isNewTravelerAccountValid(email, password)) {
                    travelerAccount = new TravelerAccount(email, password);
                    database.addNewTravelerAccount(travelerAccount);
                    System.out.println("\tSuccess\n");
                }
            }
            else {
                System.out.println ("Password does not match. Please try again");
            }
        }while(!validAccountDetails);
    return  travelerAccount;
    }
}

