import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelerTest {

    @DisplayName("Tests that false will be returned if the travelerAccount is null and cannot login")
    @Test
    void unsuccessfulLoginIfTravelerAccountIsNull(){
        Budget budget = new Budget();
        Schedule schedule = new Schedule();
        TravelerAccount travelerAccount = null;
        Traveler traveler = new Traveler(schedule, budget);

        assertFalse(traveler.login(travelerAccount));
    }

    @DisplayName("Test that true will be returned if the travelerAccount is not null and can login")
    @Test
    void successfulLoginIfTravelerAccountIsNotNull(){
        Budget budget = new Budget();
        Schedule schedule = new Schedule();
        TravelerAccount travelerAccount = new TravelerAccount("example22@gmail.com", "Password$11");
        Traveler traveler = new Traveler(schedule, budget);

        assertTrue(traveler.login(travelerAccount));
    }
}