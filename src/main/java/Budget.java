public class Budget {

    double travelerBudget;

    public void setTravelerBudget(double travelerBudget) {
        this.travelerBudget = travelerBudget;
    }

    public boolean isEstimateOverBudget(double totalCost){
        if(totalCost > travelerBudget){
            System.out.println("OVER BUDGET! CANNOT ADD ACTIVITY");
            return true;
        }
        else
            return false;
    }
}
