import java.math.BigDecimal;

public class TwoState  implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Two") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(2);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
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
