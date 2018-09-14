public class QuarterState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Quarter") > 0) {
            if (changeCalculator.getAmount() - 0.25 >= 0) {
                changeCalculator.deductAmount("Quarter", 0.25);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Quarter: " + count);
        }
        changeCalculator.setState(new DimeState());
        changeCalculator.startCalculate();
    }

}
