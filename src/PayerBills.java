import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayerBills {

    private double paid = 0.0;
    private HashMap<String, Integer> billsCounter;

    public PayerBills(HashMap<String, Integer> listOfDenominations) {
        this.billsCounter = new HashMap<>();
        initializePayerBills(listOfDenominations);
    }

    public void initializePayerBills(HashMap<String, Integer> listOfDenominations) {
        for (Map.Entry<String, Integer> entry : listOfDenominations.entrySet()) {
            String bill = entry.getKey();
            int amount = entry.getValue();
            addTotalPaid(bill, amount);
            this.billsCounter.put(bill, amount);
        }
    }

    public HashMap<String, Integer> getBillsCounter() {
        return billsCounter;
    }

    public void addTotalPaid(String bill, int amount) {
        if (bill.equals("Hundred")) {
            paid = paid + 100.0 * amount;
        } else if (bill.equals("Fifty")) {
            paid = paid + 50.0 * amount;
        } else if (bill.equals("Twenty")) {
            paid = paid + 20.0 * amount;
        } else if (bill.equals("Ten")) {
            paid = paid + 10.0 * amount;
        } else  if (bill.equals("Five")) {
            paid = paid + 5.0 * amount;
        } else if (bill.equals("Two")) {
            paid = paid + 2.0 * amount;
        } else if (bill.equals("One")) {
            paid = paid + 1.0 * amount;
        } else if (bill.equals("Quarter")) {
            paid = paid + 0.25 * amount;
        } else if (bill.equals("Dime")) {
            paid = paid + 0.10 * amount;
        } else if (bill.equals("Nickel")) {
            paid = paid + 0.05 * amount;
        } else if (bill.equals("Penny")){
            paid = paid + 0.01 * amount;
        }
    }

    public double getPaid() {
        return this.paid;
    }

}
