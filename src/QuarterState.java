public class QuarterState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 0.25 >= 0) {
            changeCalculator.deductAmount(0.25);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Quarter: " + count);
        }
        changeCalculator.setState(new DimeState());
        changeCalculator.startCalculate();
    }

}
