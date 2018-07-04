public class OneState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 1 >= 0) {
            changeCalculator.deductAmount(1);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$1 bills: " + count);
        }
        changeCalculator.setState(new QuarterState());
        changeCalculator.startCalculate();
    }

}
