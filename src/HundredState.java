public class HundredState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 100 >= 0) {
            changeMaker.deductAmount(100);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$100 bills: " + count);
        }
        changeMaker.setState(new FiftyState());
        changeMaker.startCalculate();
    }

}
