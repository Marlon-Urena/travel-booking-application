import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstimateTest {

    @DisplayName("Test that desired amount will be added to total cost if it is not over budget")
    @Test
    void addToTotalCost() {
        Budget budget = new Budget();
        budget.setTravelerBudget(100);
        Estimate estimate = new Estimate(budget);

        assertTrue(estimate.addToTotalCost(20));
    }

    @DisplayName("Test that desired amount cannot be added because it is over budget")
    @Test
    void cannotAddToTotalCost(){
        Budget budget = new Budget();
        budget.setTravelerBudget(0);
        Estimate estimate = new Estimate(budget);

        assertFalse(estimate.addToTotalCost(20));
    }

    @Test
    void provideEstimate() {
    }
}