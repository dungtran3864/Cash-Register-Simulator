public class HundredState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 100 >= 0) {
            changeCalculator.deductAmount(100);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$100 bills: " + count);
        }
        changeCalculator.setState(new FiftyState());
        changeCalculator.startCalculate();
    }

}
