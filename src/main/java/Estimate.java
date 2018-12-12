public class Estimate {
    Budget budget;
    private double totalCost = 0;

    public Estimate(Budget budget){
        this.budget = budget;
    }

    public boolean addToTotalCost(double amount){
        if(budget.isEstimateOverBudget(amount + totalCost)) {
            totalCost += amount;
            return true;
        }
        else{
            return false;
        }
    }

    public Double provideEstimate(){
        return totalCost;
    }
}

