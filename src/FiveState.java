public class FiveState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 5 >= 0) {
            changeCalculator.deductAmount(5);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$5 bills: " + count);
        }
        changeCalculator.setState(new TwoState());
        changeCalculator.startCalculate();
    }

}
