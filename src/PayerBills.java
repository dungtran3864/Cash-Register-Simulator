import java.util.Scanner;

public class PayerBills {

    private double paid = 0.0;
    private BillsCounter billsCounter;

    public PayerBills() {
        this.billsCounter = new BillsCounter();
        initializePayerBills();
    }

    public void initializePayerBills() {
        int billsNumber;

        Scanner scanner = new Scanner(System.in);
        System.out.print("$100 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 100.0 * billsNumber;
        billsCounter.addBill("Hundred", billsNumber);

        System.out.print("$50 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 50.0 * billsNumber;
        billsCounter.addBill("Fifty", billsNumber);

        System.out.print("$20 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 20.0 * billsNumber;
        billsCounter.addBill("Twenty", billsNumber);

        System.out.print("$10 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 10.0 * billsNumber;
        billsCounter.addBill("Ten", billsNumber);

        System.out.print("$5 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 5.0 * billsNumber;
        billsCounter.addBill("Five", billsNumber);

        System.out.print("$2 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 2.0 * billsNumber;
        billsCounter.addBill("Two", billsNumber);

        System.out.print("$1 bills given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 1.0 * billsNumber;
        billsCounter.addBill("One", billsNumber);

        System.out.print("Quarter given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.25 * billsNumber;
        billsCounter.addBill("Quarter", billsNumber);

        System.out.print("Dime given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.10 * billsNumber;
        billsCounter.addBill("Dime", billsNumber);

        System.out.print("Nickel given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.05 * billsNumber;
        billsCounter.addBill("Nickel", billsNumber);

        System.out.print("Penny given: ");
        billsNumber = scanner.nextInt();
        paid = paid + 0.01 * billsNumber;
        billsCounter.addBill("Penny", billsNumber);

        System.out.println();
        saveNewBills();
    }

    public void saveNewBills() {
        TextReader textReader = new TextReader(billsCounter);
        textReader.writeFile();
    }

    public double getPaid() {
        return this.paid;
    }

}
