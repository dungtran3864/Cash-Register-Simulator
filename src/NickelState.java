import java.math.BigDecimal;

public class NickelState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Nickel") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(0.05);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Nickel", 0.05);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Nickel: " + count);
        }
        changeCalculator.setState(new PennyState());
        changeCalculator.startCalculate();
    }

}
