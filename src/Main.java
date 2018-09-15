import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total cost: ");
        double cost = scanner.nextDouble();
        cost = Math.round(cost * 100.0) / 100.0;
        PayerBills payerBills = new PayerBills();
        double paid = payerBills.getPaid();
        paid = Math.round(paid * 100.0) / 100.0;
        scanner.close();
        ChangeCalculator changeCalculator = new ChangeCalculator(cost, paid, payerBills.getBillsCounter());
        changeCalculator.startCalculate();
//        payerBills.saveNewBills();
    }
}
