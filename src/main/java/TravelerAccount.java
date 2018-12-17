import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static java.time.LocalDate.parse;

public class TravelerAccount {
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Map<LocalDate, File> previousBookingsMap= new HashMap<>(); //Possible to use keyset and store in List so that it may be organized. Booking information will be stored in json format
    static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public TravelerAccount(String email, String password) {
        this.email = email;
        this.password = password;
        //There will be code to validate the email and password
    }

    public String getLoginCredentials() { //Database will ask for this method and Database will compare in this style
        return this.email + " " + this.password;
    }

    public static boolean isNewTravelerAccountValid(String email, String password) {
        EmailValidator validator= EmailValidator.getInstance();

        if (validator.isValid(email) && password.matches(pattern)) {
            //I changed this so the  new travelerAccount is being declared in the TravelProgram because the travel program was remaining null not matter what I did
            return true;
        }
        return false;
    }

    public boolean changePassword(String password) {
        //have code here that will determine if password is valid(maybe based on whether it has appropriate characters and length
        if(password.matches(pattern)) {
            this.password=password;
            return true;
        }
        return false;
    }

    public boolean changeEmail(String email) {
        //have code here that will determine if email is valid
        EmailValidator validator = EmailValidator.getInstance();

        if (validator.isValid(email)) {
            this.email=email;
            return true;
        }
        return false;

    }

    public boolean changeDateOfBirth(LocalDate dateOfBirth) {
        if (isValidDateOfBirth(dateOfBirth,13)) {
            this.dateOfBirth = dateOfBirth;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public static TravelerAccount login(Database dataBase, String email, String password) throws Exception {
        return dataBase.loginToTravelerAccount(email + " " + password);
    }

    //Add the getters and rest of setters
    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAddressLine1(String address){
        this.addressLine1 = address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }

    private boolean isValidDateOfBirth(String dateOfBirth, int validAge) {
            LocalDate today = LocalDate.now();
            LocalDate validBeforeThisDate = parse(dateOfBirth);
            if (calculateAge(validBeforeThisDate, today) >= validAge) {
                return true;
            }
        return false;
    }

    private boolean isValidDateOfBirth(LocalDate dateOfBirth, int validAge) {
        LocalDate today = LocalDate.now();
        if (calculateAge(dateOfBirth, today) >= validAge) {
            return true;
        }
        return false;
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public String saveBookingInformation(Object booking, Database database) {
        int length = 8;
        String chars = "0123456789";
        String bookingNumber;
        String todayString;
        do {
            bookingNumber = new Random().ints(length, 0, chars.length())
                    .mapToObj(i -> "" + chars.charAt(i))
                    .collect(Collectors.joining());
        }while(database.isBookingNumberInSystem(bookingNumber)==false);

        new File(System.getProperty("user.home"), "travel").mkdirs();
        String newFileName = (bookingNumber + "-" + "travelBooking.json");
        File filePath = new File(System.getProperty("user.home") + File.separator + "travel" + File.separator + newFileName );

        try {
            database.addNewBookingData(bookingNumber, filePath, booking);
            LocalDate today = LocalDate.now();


            this.previousBookingsMap.put(today, filePath);

            return bookingNumber;
        }
        catch (IOException e) {
            return "Unable to save booking information, we apologise for the inconvenience.";
        }
    }
}

