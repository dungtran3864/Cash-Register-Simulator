public class HundredState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Hundred") > 0) {
            if (changeCalculator.getAmount() - 100 >= 0) {
                changeCalculator.deductAmount("Hundred", 100);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$100 bills: " + count);
        }
        changeCalculator.setState(new FiftyState());
        changeCalculator.startCalculate();
    }

}
