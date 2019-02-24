import java.math.BigDecimal;

public class OneState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("One") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(1);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("One", 1);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$1: " + count);
        }
        changeCalculator.setState(new QuarterState());
        changeCalculator.startCalculate();
    }

}
