import io.swagger.client.api.DefaultApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.io.IOException;
import java.time.LocalDate;

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

    @DisplayName("Test that true will be returned with a valid password change")
    @Test
    void changePasswordReturnsTrue(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        String newPassword = "Newpass$11";

        assertTrue(travelerAccount.changePassword(newPassword));
    }

    @DisplayName("Test that false will be returned with a invalid password change")
    @Test
    void changePasswordReturnsFalse(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        String newPassword = "new";

        assertFalse(travelerAccount.changePassword(newPassword));
    }

    @DisplayName("Test that true will be returned with a valid email change")
    @Test
    void changEmailReturnsTrue(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        String newEmail = "newexample24@gmail.com";

        assertTrue(travelerAccount.changeEmail(newEmail));
    }

    @DisplayName("Test that false will be returned with a invalid email change")
    @Test
    void changeEmailReturnsFalse(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        String newEmail = "new";

        assertFalse(travelerAccount.changeEmail(newEmail));
    }

    @DisplayName("Test that true will be returned with a valid date of birth change")
    @Test
    void changeDateOfBirthReturnsTrue(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        LocalDate newDateOfBirth = LocalDate.parse("1998-08-05");

        assertTrue(travelerAccount.changeDateOfBirth(newDateOfBirth));
    }


    @DisplayName("Test that false will be returned with a invalid date of birth change")
    @Test
    void changeDateOfBirthReturnsFalse(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        LocalDate newDateOfBirth = LocalDate.parse("2020-08-09");

        assertFalse(travelerAccount.changeDateOfBirth(newDateOfBirth));
    }

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

    @DisplayName("Test that saveBookingInformation will not throw exception")
    @Test
    void saveBookingInformationDoesNotThrowException(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        DefaultApi apiInstance = new DefaultApi();
        Booking flightBooking = new FlightBooking(apiInstance);
        Database database = new Database();

        boolean isExceptionThrown;

        try {
            travelerAccount.saveBookingInformation(flightBooking, database);
            isExceptionThrown = false;
        }catch (Exception e){
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @DisplayName("Test that saveBookingInformation will throw exception")
    @Test
    void saveBookingInformationThrowsException(){
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        DefaultApi apiInstance = new DefaultApi();
        Booking flightBooking = new FlightBooking(apiInstance);
        Database database = null;

        boolean isExceptionThrown;

        try {
            travelerAccount.saveBookingInformation(flightBooking, database);
            isExceptionThrown = false;
        }catch (Exception e){
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }
}
