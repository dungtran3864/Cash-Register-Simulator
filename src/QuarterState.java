public class QuarterState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 0.25 >= 0) {
            changeMaker.deductAmount(0.25);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Quarter: " + count);
        }
        changeMaker.setState(new DimeState());
        changeMaker.startCalculate();
    }

}
