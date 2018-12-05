import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private Map<String, File> bookingMap = new HashMap<>();
    private Map<String, TravelerAccount> userMap = new HashMap<>();
    private File bookingFile;
    TravelerAccount travelerAccount;

    public boolean addNewTravelerAccount(Traveler Account) {

        return false;
    }

    public boolean removeTravelerAccount(String email) {
        return false;
    }

    public TravelerAccount loginToTravelerAccount(String login){

        return userMap.get(login);
    }


}
