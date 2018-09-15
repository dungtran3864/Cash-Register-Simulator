import java.math.BigDecimal;

public class QuarterState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Quarter") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(0.25);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
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
