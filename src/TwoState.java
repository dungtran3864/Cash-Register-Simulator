public class TwoState  implements State {

    private int count = 0;

    public void calculateCurrency(ChangeCalculator changeCalculator) {
        while (changeCalculator.getAmount() - 2 >= 0) {
            changeCalculator.deductAmount(2);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$2 bills: " + count);
        }
        changeCalculator.setState(new OneState());
        changeCalculator.startCalculate();
    }

}
