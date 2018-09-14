public class PennyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.billsRemain("Penny") > 0) {
            if (changeCalculator.getAmount() - 0.01 >= 0) {
                changeCalculator.deductAmount("Penny", 0.01);
                this.count += 1;
            } else {
                break;
            }
        }
        if (count != 0) {
            changeCalculator.saveBillString("Penny: " + count);
        }
        if (changeCalculator.getAmount() == 0) {
            changeCalculator.printBillString();
        } else {
            System.out.println("You don't have enough bills to change!");
        }
    }

}
