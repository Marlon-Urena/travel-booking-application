import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @Test
    void setTravelerBudget() {
    }

    @DisplayName("Test if true is returned if Estimate is over Budget")
    @Test
    void isEstimateOverBudget() {
        Budget budget = new Budget();
        budget.setTravelerBudget(100);

        assertTrue(budget.isEstimateOverBudget(150));
    }

    @DisplayName("Test if true is returned if Estimate is over Budget")
    @Test
    void isEstimateOverBudgetFalse() {
        Budget budget = new Budget();
        budget.setTravelerBudget(100);

        assertFalse(budget.isEstimateOverBudget(50));
    }
}