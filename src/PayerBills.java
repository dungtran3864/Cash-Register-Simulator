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
        int billsNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.print("$100 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 100.0 * billsNumber;
        billsCounter.put("Hundred", billsNumber);

        System.out.print("$50 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 50.0 * billsNumber;
        billsCounter.put("Fifty", billsNumber);

        System.out.print("$20 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 20.0 * billsNumber;
        billsCounter.put("Twenty", billsNumber);

        System.out.print("$10 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 10.0 * billsNumber;
        billsCounter.put("Ten", billsNumber);

        System.out.print("$5 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 5.0 * billsNumber;
        billsCounter.put("Five", billsNumber);

        System.out.print("$2 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 2.0 * billsNumber;
        billsCounter.put("Two", billsNumber);

        System.out.print("$1 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 1.0 * billsNumber;
        billsCounter.put("One", billsNumber);

        System.out.print("Quarter given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.25 * billsNumber;
        billsCounter.put("Quarter", billsNumber);

        System.out.print("Dime given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.10 * billsNumber;
        billsCounter.put("Dime", billsNumber);

        System.out.print("Nickel given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.05 * billsNumber;
        billsCounter.put("Nickel", billsNumber);

        System.out.print("Penny given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.01 * billsNumber;
        billsCounter.put("Penny", billsNumber);

        System.out.println("Total paid: " + this.paid);

    }

    public HashMap<String, Integer> getBillsCounter() {
        return billsCounter;
    }

    public double getPaid() {
        return this.paid;
    }

}
