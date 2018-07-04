public class OneState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 1 >= 0) {
            changeMaker.deductAmount(1);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$1 bills: " + count);
        }
        changeMaker.setState(new QuarterState());
        changeMaker.startCalculate();
    }

}
