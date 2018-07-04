public class FiftyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 50 >= 0) {
            changeCalculator.deductAmount(50);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$50 bills: " + count);
        }
        changeCalculator.setState(new TwentyState());
        changeCalculator.startCalculate();
    }

}
