import java.math.BigDecimal;

public class PennyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Penny") > 0) {
            BigDecimal amountReduced = BigDecimal.valueOf(0.01);
            if (changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 0 ||
                    changeCalculator.getAmount().subtract(amountReduced).compareTo(BigDecimal.ZERO) == 1) {
                changeCalculator.deductAmount("Penny", 0.01);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Penny: " + count);
        }
        if (changeCalculator.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            changeCalculator.updateBillString();
        } else {
            changeCalculator.noticeNotEnoughBills();
        }
    }

}
