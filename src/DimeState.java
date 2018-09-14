public class DimeState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Dime") > 0) {
            if (changeCalculator.getAmount() - 0.10 >= 0) {
                changeCalculator.deductAmount("Hundred", 0.10);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Dime: " + count);
        }
        changeCalculator.setState(new NickelState());
        changeCalculator.startCalculate();
    }

}
