public class TwentyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Twenty") > 0) {
            if (changeCalculator.getAmount() - 20 >= 0) {
                changeCalculator.deductAmount("Twenty", 20);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$20 bills: " + count);
        }
        changeCalculator.setState(new TenState());
        changeCalculator.startCalculate();
    }

}
