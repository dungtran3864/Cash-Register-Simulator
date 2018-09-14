public class ChangeCalculator {

    private double amount;
    private State currentState;
    private BillsCounter billsCounter;
    private QueueReader queueReader;

    public ChangeCalculator(double cost, double paid) {
        billsCounter = new BillsCounter();
        queueReader = new QueueReader();
        this.amount = paid - cost;
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

    public double getAmount() {
        return this.amount;
    }

    public void deductAmount(String bill, double amount) {
        this.amount -= amount;
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
