public class TenState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 10 >= 0) {
            changeMaker.deductAmount(10);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$10 bills: " + count);
        }
        changeMaker.setState(new FiveState());
        changeMaker.startCalculate();
    }

}
