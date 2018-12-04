public class Estimate {
    private double budget;
    private double totalCost = 0;

    //HashMap of how much each "activity" cost?

    public void setEstimate(double budget) {
        this.budget = budget;
    }

    public void addToTotalCost(double amount){
        totalCost += amount;
    }


    public Double provideEstimate(){

        return totalCost;
    }
}
