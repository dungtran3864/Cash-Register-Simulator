public class TenState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 10 >= 0) {
            changeCalculator.deductAmount(10);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$10 bills: " + count);
        }
        changeCalculator.setState(new FiveState());
        changeCalculator.startCalculate();
    }

}
