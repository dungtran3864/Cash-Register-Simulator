public class TenState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Ten") > 0) {
            if (changeCalculator.getAmount() - 10 >= 0) {
                changeCalculator.deductAmount("Ten", 10);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$10 bills: " + count);
        }
        changeCalculator.setState(new FiveState());
        changeCalculator.startCalculate();
    }

}
