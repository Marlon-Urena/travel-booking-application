import org.apache.commons.validator.routines.EmailValidator;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class TravelerAccount {
    private String firstName;
    private String middleName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private Date dateOfBirth;
    private String email;
    private String password;
    private Map<Date, File> previousBookingsMap; //Possible to use keyset and store in List so that it may be organized. Booking information will be stored in json format
    static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    public TravelerAccount(String email, String password) {
        this.email = email;
        this.password = password;
        //There will be code to validate the email and password
    }

    public String getLoginCredentials() { //Database will ask for this method and Database will compare in this style
        return this.email + " " + this.password;
    }

    public void changePassword(String password) {
        //have code here that will determine if password is valid(maybe based on whether it has appropriate characters and length
        this.password=password;
    }

    public void changeEmail(String email) {
        //have code here that will determine if email is valid
        this.email=email;
    }

    public void changedateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }


    public static TravelerAccount login(Database dataBase, String email, String password) throws Exception {
        return dataBase.loginToTravelerAccount(email + " " + password);
    }

    public static boolean createNewTravelerAccount(TravelerAccount travelerAccount, Database database, String email, String password) {
        boolean validEmail = false;
        boolean validPassword = false;
        EmailValidator validator= EmailValidator.getInstance();

        if (validator.isValid(email) && password.matches(pattern)) {
            travelerAccount = new TravelerAccount(email, password);
            database.addNewTravelerAccount(travelerAccount);
            return true;
        }
        return false;
    }

    //Add the getters and rest of setters
}
