public class FiftyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Fifty") > 0) {
            if (changeCalculator.getAmount() - 50 >= 0) {
                changeCalculator.deductAmount("Fifty", 50);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$50 bills: " + count);
        }
        changeCalculator.setState(new TwentyState());
        changeCalculator.startCalculate();
    }

}
