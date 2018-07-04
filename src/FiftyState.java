public class FiftyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 50 >= 0) {
            changeMaker.deductAmount(50);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$50 bills: " + count);
        }
        changeMaker.setState(new TwentyState());
        changeMaker.startCalculate();
    }

}
