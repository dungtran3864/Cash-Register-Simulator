public class NickelState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Nickel") > 0) {
            if (changeCalculator.getAmount() - 0.05 >= 0) {
                changeCalculator.deductAmount("Nickel", 0.05);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Nickel: " + count);
        }
        changeCalculator.setState(new PennyState());
        changeCalculator.startCalculate();
    }

}
