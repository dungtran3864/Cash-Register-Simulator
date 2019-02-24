import java.math.BigDecimal;

public class TwentyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Twenty") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(20);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Twenty", 20);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$20: " + count);
        }
        changeCalculator.setState(new TenState());
        changeCalculator.startCalculate();
    }

}
