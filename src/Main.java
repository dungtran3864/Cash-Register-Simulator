import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of money to change: ");
        double amount = scanner.nextDouble();
        scanner.close();
        ChangeMaker changeMaker = new ChangeMaker(amount);
        changeMaker.startCalculate();
    }
}
