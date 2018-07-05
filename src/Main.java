import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter total cost: ");
        double cost = scanner.nextDouble();
        cost = Math.round(cost * 100.0) / 100.0;
        System.out.print("Enter paid amount: ");
        double paid = scanner.nextDouble();
        paid = Math.round(paid * 100.0) / 100.0;
        scanner.close();
        ChangeCalculator changeCalculator = new ChangeCalculator(cost, paid);
        changeCalculator.startCalculate();
    }
}
