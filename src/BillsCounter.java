import java.util.HashMap;

public class BillsCounter {

    private HashMap<String, Integer> billscounter;

    public BillsCounter() {
        this.billscounter = new HashMap<>();
        this.billscounter.put("Hundred", 0);
        this.billscounter.put("Fifty", 0);
        this.billscounter.put("Twenty", 0);
        this.billscounter.put("Ten", 0);
        this.billscounter.put("Five", 0);
        this.billscounter.put("Two", 0);
        this.billscounter.put("One", 0);
        this.billscounter.put("Quarter", 0);
        this.billscounter.put("Dime", 0);
        this.billscounter.put("Nickel", 0);
        this.billscounter.put("Penny", 0);
        initializeBills();
    }

    public void initializeBills() {
        TextReader textReader = new TextReader(this);
        textReader.initializeReading();
    }

    public void addBill(String bill, Integer amount) {
        int currentAmount = this.billscounter.get(bill);
        currentAmount = currentAmount + amount;
        this.billscounter.put(bill, currentAmount);
    }

    public void subtractBill (String bill, Integer amount) {
        int currentAmount = this.billscounter.get(bill);
        currentAmount = currentAmount - amount;
        this.billscounter.put(bill, currentAmount);
    }

    public int getBillsRemain(String bill) {
        return this.billscounter.get(bill);
    }

    public HashMap<String, Integer> getBillscounter() {
        return billscounter;
    }

    public void saveNewBills() {
        TextReader textReader = new TextReader(this);
        textReader.writeFile();
    }

}
