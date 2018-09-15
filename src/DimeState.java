import java.math.BigDecimal;

public class DimeState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Dime") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(0.10);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Dime", 0.10);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Dime: " + count);
        }
        changeCalculator.setState(new NickelState());
        changeCalculator.startCalculate();
    }

}
