import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @DisplayName("Tests that activity will be returned when requested")
    @Test
    void getActivity() {
        Activity activity = new Activity();

        assertEquals("Skydiving", activity.getActivity(1));
    }

    @DisplayName("Tests that price of activity will be returned")
    @Test
    void getActivityPrice() {
        Activity activity = new Activity();

        assertEquals(75, activity.getActivityPrice(6));
    }
}