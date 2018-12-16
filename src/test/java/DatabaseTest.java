import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @DisplayName("Tests that exception will be thrown when traveler account is null")
    @Test
    public void loginToTravelerAccountNull() {
        String login = "example22@gmail.com Password$11";
        Database database = new Database();

        boolean isExceptionThrown;
        try{
            database.loginToTravelerAccount(login);
            isExceptionThrown = false;
        }catch (Exception e){
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }

    @DisplayName("Test that exception will not be thrown if traveler account is not null")
    @Test
    public void loginToTravelerAccountIsNotNull(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = email + " " + password;
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        database.addNewTravelerAccount(account);

        boolean isExceptionThrown;
        try{
            database.loginToTravelerAccount(login);
            isExceptionThrown = false;
        }catch (Exception e){
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @DisplayName("Tests that a successful login will return a mathcing traveler account because of a successful login")
    @Test
    public void successfulLogin(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = email + " " + password;
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        TravelerAccount account2 = null;
        database.addNewTravelerAccount(account);

        try {
            account2 = database.loginToTravelerAccount(login);
        } catch (Exception e) {
           account2 = null;
        }

        assertEquals(account, account2);
    }


    @DisplayName("")
    @Test
    public void searchOldBookingData() {
    }
}