public class Estimate {
    Budget budget;
    private double totalCost = 0;

    //HashMap of how much each "activity" cost?
    //Budget will now check if the traveler is going over budget. Estimate will provide the estimate.

    public Estimate(Budget budget){
        this.budget = budget;
    }

    public void addToTotalCost(double amount){
        if(budget.isEstimateOverBudget(amount)) {
            totalCost += amount;
        }
    }

    public Double provideEstimate(){
        return totalCost;
    }
}
