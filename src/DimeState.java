public class DimeState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 0.10 >= 0) {
            changeCalculator.deductAmount(0.10);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Dime: " + count);
        }
        changeCalculator.setState(new NickelState());
        changeCalculator.startCalculate();
    }

}
