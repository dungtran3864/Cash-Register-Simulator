public class TwoState  implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Two") > 0) {
            if (changeCalculator.getAmount() - 2 >= 0) {
                changeCalculator.deductAmount("Two", 2);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$2 bills: " + count);
        }
        changeCalculator.setState(new OneState());
        changeCalculator.startCalculate();
    }

}
