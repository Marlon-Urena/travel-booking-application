import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, File> bookingMap = new HashMap<>();
    private Map<String, TravelerAccount> userMap = new HashMap<>();

    public void addNewTravelerAccount(TravelerAccount travelerAccount) {
        userMap.put(travelerAccount.getEmail(), travelerAccount);
    }

    public void removeTravelerAccount(String email) {
        userMap.remove(email);
    }

    public TravelerAccount loginToTravelerAccount(String login) throws Exception, RuntimeException {
        String inputEmail;
        String inputPassword;
        boolean successfulLogin = false;
        TravelerAccount travelerAccount;

        inputEmail = login.substring(0, login.indexOf(" ")); // Looks at what's before the space
        inputPassword = login.substring(login.indexOf(" ")+1); // Looks at what's after the space

        travelerAccount = userMap.get(inputEmail);

        if (travelerAccount == null) {
            throw new Exception("EMAIL DOESN'T EXIST"); //Would replace with custom exception for incorrect email
        }
        else if (travelerAccount.getLoginCredentials().equals(login)){
            successfulLogin = true;
        }
        else if (!successfulLogin) {
            throw new RuntimeException("INCORRECT EMAIL AND PASSWORD COMBINATION"); //Would replace with custom exception for incorrect email and password combination
        }

             /*Thinking about creating an exception for (email doesn't exist, incorrect password,
                                        and a big maybe on too many login attempts) we may have to rethink how we use the email
                                        and password in the Database however*/
        return userMap.get(travelerAccount.getEmail());
    }

    public void addNewBookingData(String bookingNumber, File bookingFile) {
    /*Have to rethink how I am going to implement. May need to add an additional parameter for JSON resource that we get
    through api. May consider have private method that creates a folder and saves JSON file
     */
        bookingMap.put(bookingNumber, bookingFile);
    }

    public File searchOldBookingData(String bookingNumber){
        return bookingMap.get(bookingNumber);
    }
}