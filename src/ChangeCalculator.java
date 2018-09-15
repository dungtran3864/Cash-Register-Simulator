import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;

public class ChangeCalculator {

    private BigDecimal amount;
    private State currentState;
    private BillsCounter billsCounter;
    private QueueReader queueReader;
    private HashMap<String, Integer> payerBills;

    public ChangeCalculator(double cost, double paid, HashMap<String, Integer> payerBills) {
        billsCounter = new BillsCounter();
        queueReader = new QueueReader();
        this.payerBills = payerBills;
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
        updateTotalBills();
        this.billsCounter.saveNewBills();
    }

    public void updateTotalBills() {
        for (HashMap.Entry<String, Integer> entry : payerBills.entrySet()) {
            if (entry.getValue() > 0) {
                this.billsCounter.addBill(entry.getKey(), entry.getValue());
            }
        }
    }

}
