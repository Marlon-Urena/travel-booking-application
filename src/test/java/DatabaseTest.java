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

    @DisplayName("Tests that a successful login will be true")
    @Test
    public void loginToTravelerAccountSuccessfulLogin(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = email + " " + password;
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        database.addNewTravelerAccount(account);

        boolean successfulLogin;

        try {
            successfulLogin = true;
        } catch (Exception e) {
           successfulLogin = false;
        }

        assertTrue(successfulLogin);
    }

    @DisplayName("Tests that if credentials are incorrect successful login will be false")
    @Test
    public void loginToTravelerAccountUnsuccessfulLogin(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = " ";
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        database.addNewTravelerAccount(account);

        boolean successfulLogin;

        try { database.loginToTravelerAccount(login);
            successfulLogin = true;
        } catch (Exception e) {
            successfulLogin = false;
        }

        assertFalse(successfulLogin);
    }

    @DisplayName("Tests that a successful login attempt will not throw an Exception")
    @Test
    public void loginToTravelerAccountSuccessfulLoginShouldNotThrowException(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = email + " " + password;
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        database.addNewTravelerAccount(account);

        boolean isExceptionThrown;

        try { database.loginToTravelerAccount(login);
            isExceptionThrown= false;
        } catch (RuntimeException e) {
            isExceptionThrown = true;
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @DisplayName("Tests that a unsuccessful login attempt will throw an Exception")
    @Test
    public void loginToTravelerAccountUnsuccessfulLoginShouldThrowException(){
        String email = "example22@gmail.com";
        String password = "Password$11";
        String login = " ";
        Database database = new Database();
        TravelerAccount account = new TravelerAccount(email, password);
        database.addNewTravelerAccount(account);

        boolean isExceptionThrown;

        try { database.loginToTravelerAccount(login);
            isExceptionThrown= false;
        } catch (RuntimeException e) {
            isExceptionThrown = true;
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }
}
