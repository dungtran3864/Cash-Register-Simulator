public class ChangeMaker {

    private double amount;

    private State currentState;

    public ChangeMaker(double amount) {
        this.amount = amount;
        this.currentState = new HundredState();
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
