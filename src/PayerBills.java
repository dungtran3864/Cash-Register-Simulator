import java.util.HashMap;
import java.util.Scanner;

public class PayerBills {

    private double paid = 0.0;
    private HashMap<String, Integer> billsCounter;

    public PayerBills() {
        this.billsCounter = new HashMap<>();
        initializePayerBills();
    }

    public void initializePayerBills() {

        System.out.println("Input in the bills and number of each bill the following form: bill1 amount1, bill2 amount2, etc");
        System.out.println("Failure to follow the form correctly will result in a failed transaction and starting over");
        System.out.print("Now type in your bills: ");

        Scanner scanner = new Scanner(System.in);
        String billsString = scanner.nextLine();
        String[] billsList = billsString.split(",");

        for (String itemString : billsList) {
            String[] itemList = itemString.trim().split("\\s+");
            String bill = itemList[0].toLowerCase();
            bill = bill.substring(0,1).toUpperCase() + bill.substring(1).toLowerCase();
            int amount = Integer.parseInt(itemList[1]);
            addTotalPaid(bill, amount);
            this.billsCounter.put(bill, amount);
        }

        System.out.println("Total paid: " + this.paid);

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
