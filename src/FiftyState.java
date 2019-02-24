import java.math.BigDecimal;

public class FiftyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Fifty") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(50);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Fifty", 50);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("$50: " + count);
        }
        changeCalculator.setState(new TwentyState());
        changeCalculator.startCalculate();
    }

}
