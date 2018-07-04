public class TwentyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 20 >= 0) {
            changeMaker.deductAmount(20);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$20 bills: " + count);
        }
        changeMaker.setState(new TenState());
        changeMaker.startCalculate();
    }

}
