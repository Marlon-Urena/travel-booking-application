import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelerAccountTest {

    @DisplayName("Tests if login credentials will be returned if entered correctly")
    @Test
    void LoginCredentialsShouldReturnTrue() {
        String email = "example22@gmail.com";
        String password = "Password$11";
        String correct = email + " " + password;
        TravelerAccount travelerAccount = new TravelerAccount(email, password);

        assertEquals(correct, travelerAccount.getLoginCredentials());
    }

    @DisplayName("Test that true will be returned with valid inputs")
    @Test
    void isNewTravelerAccountValidShouldReturnTrue() {
        String email = "example22@gmail.com";
        String password = "Password$11";
        TravelerAccount travelerAccount = new TravelerAccount(email, password);

        assertTrue(travelerAccount.isNewTravelerAccountValid(email, password));
    }

    @DisplayName("Test that false will be returned with an invalid password")
    @Test
    void isNewTravelerAccountValidShouldReturnFalseWithInvalidPassword() {
        String email = "example22@gmail.com";
        String password = "password11";
        TravelerAccount travelerAccount = new TravelerAccount(email, password);

        assertFalse(travelerAccount.isNewTravelerAccountValid(email, password));
    }

    @DisplayName("Test that false will be returned with an invalid email")
    @Test
    void isNewTravelerAccountValidShouldReturnFalseWithInvalidEmail() {
        String email = "example22";
        String password = "Password$11";
        TravelerAccount travelerAccount = new TravelerAccount(email, password);

        assertFalse(travelerAccount.isNewTravelerAccountValid(email, password));
    }

    /*@DisplayName("")
    @Test
    void getEmail() {
    }*/

    @DisplayName("Tests login method")
    @Test
    void loginSuccessful() {
        Database database = new Database();
        String email = "example22@gmail.com";
        String password = "Password$11";
        TravelerAccount travelerAccount1 = new TravelerAccount(email, password);
        database.addNewTravelerAccount(travelerAccount1);

        boolean success;

        try {
            TravelerAccount travelerAccount2 = travelerAccount1.login(database, email, password);
            success = true;
        } catch (Exception e) {
            System.out.println("caught");
            success = false;
        }

        assertTrue(success);
    }
}