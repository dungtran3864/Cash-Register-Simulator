public class ChangeCalculator {

    private double amount;

    private State currentState;

    public ChangeCalculator(double cost, double paid) {
        this.amount = paid - cost;
        this.currentState = new HundredState();
        totalChange();
    }

    public void totalChange() {
        System.out.println("Total change: " + amount);
    }

    public void startCalculate() {
        this.currentState.calculateCurrency(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public double getAmount() {
        return this.amount;
    }

    public void deductAmount(double amount) {
        this.amount -= amount;
    }

}
