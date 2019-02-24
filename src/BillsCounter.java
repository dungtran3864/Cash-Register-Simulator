import java.util.HashMap;
import java.util.Iterator;

public class BillsCounter {

    private HashMap<String, Integer> billscounter;

    public BillsCounter() {
        this.billscounter = new HashMap<>();
        this.billscounter.put("Hundred", 0);
        this.billscounter.put("Fifty", 0);
        this.billscounter.put("Twenty", 0);
        this.billscounter.put("Ten", 0);
        this.billscounter.put("Five", 0);
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

    public double totalMoneyHave() {
        double total = 0.0;
        total += this.billscounter.get("Hundred") * 100.0;
        total += this.billscounter.get("Fifty") * 50.0;
        total += this.billscounter.get("Twenty") * 20.0;
        total += this.billscounter.get("Ten") * 10.0;
        total += this.billscounter.get("Five") * 5.0;
        total += this.billscounter.get("One") * 1.0;
        total += this.billscounter.get("Quarter") * 0.25;
        total += this.billscounter.get("Dime") * 0.10;
        total += this.billscounter.get("Nickel") * 0.05;
        total += this.billscounter.get("Penny") * 0.01;
        return total;
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

    public HashMap<String, Integer> getBillsCounter() {
        return billscounter;
    }

    public void saveNewBills() {
        TextReader textReader = new TextReader(this);
        textReader.writeFile();
    }

}
