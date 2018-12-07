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

    public TravelerAccount(String email, String password) {
        this.email = email;
        this.password = password;
        //There will be code to validate the email and password
    }

    public String getLoginCredentials() { //Database will ask for this method and Database will compare in this style
        return this.email + " " + this.password;
    }

    //I moved login to travelerAccount because I didn't think the Traveler should have access to the database
    public TravelerAccount login(DataBase dataBase, String login) throws Exception {
        return  dataBase.loginToTravelerAccount(login);
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
    //Add the getters and rest of setters

    private boolean isPasswordValid(String password){
        //Password requirements
        return false;
    }


}
