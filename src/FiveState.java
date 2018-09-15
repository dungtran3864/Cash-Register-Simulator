import java.math.BigDecimal;

public class FiveState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Five") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(5);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Five", 5);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$5 bills: " + count);
        }
        changeCalculator.setState(new TwoState());
        changeCalculator.startCalculate();
    }

}
