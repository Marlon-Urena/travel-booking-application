public class Estimate {
    Budget budget;
    public double totalCost = 0;

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

    public double provideEstimate(){

        return totalCost;
    }
}

