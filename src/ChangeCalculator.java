import java.math.BigDecimal;

public class ChangeCalculator {

    private BigDecimal amount;
    private State currentState;
    private BillsCounter billsCounter;
    private QueueReader queueReader;

    public ChangeCalculator(double cost, double paid) {
        billsCounter = new BillsCounter();
        queueReader = new QueueReader();
        BigDecimal costAmount = BigDecimal.valueOf(cost);
        BigDecimal paidAmount = BigDecimal.valueOf(paid);
        this.amount = paidAmount.subtract(costAmount);
        this.currentState = new HundredState();
        totalChange();
    }

    public void totalChange() {
        System.out.println("Total change: " + amount);
    }

    public void startCalculate() {
        this.currentState.calculateCurrency(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void deductAmount(String bill, double amountReduced) {
        BigDecimal reduced = BigDecimal.valueOf(amountReduced);
        this.amount = this.amount.subtract(reduced);
        this.billsCounter.subtractBill(bill, 1);
    }

    public int billsRemain(String bill) {
        return this.billsCounter.getBillsRemain(bill);
    }

    public void saveBillString(String string) {
        this.queueReader.addBillsList(string);
    }

    public void printBillString() {
        this.queueReader.printList();
        this.billsCounter.saveNewBills();
    }

}
