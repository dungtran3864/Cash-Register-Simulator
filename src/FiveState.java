public class FiveState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 5 >= 0) {
            changeMaker.deductAmount(5);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$5 bills: " + count);
        }
        changeMaker.setState(new TwoState());
        changeMaker.startCalculate();
    }

}
