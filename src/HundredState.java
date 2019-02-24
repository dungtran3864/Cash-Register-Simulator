import java.math.BigDecimal;

public class HundredState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Hundred") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(100);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
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
