public class TwentyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 20 >= 0) {
            changeCalculator.deductAmount(20);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$20 bills: " + count);
        }
        changeCalculator.setState(new TenState());
        changeCalculator.startCalculate();
    }

}
