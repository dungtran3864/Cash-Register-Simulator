public class PennyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 0.01 >= 0) {
            changeCalculator.deductAmount(0.01);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Penny: " + count);
        }
    }

}
