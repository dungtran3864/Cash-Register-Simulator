public class OneState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("One") > 0) {
            if (changeCalculator.getAmount() - 1 >= 0) {
                changeCalculator.deductAmount("One", 1);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$1 bills: " + count);
        }
        changeCalculator.setState(new QuarterState());
        changeCalculator.startCalculate();
    }

}
