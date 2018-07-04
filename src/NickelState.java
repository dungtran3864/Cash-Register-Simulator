public class NickelState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 0.05 >= 0) {
            changeCalculator.deductAmount(0.05);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Nickel: " + count);
        }
        changeCalculator.setState(new PennyState());
        changeCalculator.startCalculate();
    }

}
