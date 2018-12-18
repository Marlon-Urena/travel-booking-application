import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @DisplayName("tests that exception is not thrown if dates are valid")
    @Test
    void setDatesTrue() {
        Schedule schedule = new Schedule();

        assertTrue(schedule.setDates("2019-05-04", "2019-05-25"));
    }

    @DisplayName("tests that method returns false if dates are invalid")
    @Test
    void setDatesFalse() {
        Schedule schedule = new Schedule();

        assertFalse(schedule.setDates("2019-05-25", "2019-05-04"));
    }

    @DisplayName("tests that true is returned with valid dates")
    @Test
    void areDatesValidTrue() {
        Schedule schedule = new Schedule();

        assertTrue(schedule.areDatesValid("2019-05-04", "2019-05-25"));
    }

    @DisplayName("tests that false is returned with invalid dates")
    @Test
    void areDateValidFalse(){
        Schedule schedule = new Schedule();
        assertFalse(schedule.areDatesValid("2019-05-25", "2019-05-04"));
    }

    @DisplayName("tests that exception is not thrown with valid date entry")
    @Test
    void isDateValidDoesNotThrowException(){
        Schedule schedule = new Schedule();

        boolean isExceptionThrown;

        try {
            schedule.isDateValid("2019-05-25");
            isExceptionThrown = false;
        } catch (IOException e) {
            e.printStackTrace();
            isExceptionThrown = true;
        }

        assertFalse(isExceptionThrown);
    }

    @DisplayName("tests that exception will be thrown with invalid date entry")
    @Test
    void isDateValidDoesThrowException(){
        Schedule schedule = new Schedule();
        boolean isExceptionThrown;

        try {
            schedule.isDateValid("invalid");
            isExceptionThrown = false;
        } catch (Exception e) {
            isExceptionThrown = true;
        }

        assertTrue(isExceptionThrown);
    }
}