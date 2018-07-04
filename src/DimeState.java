public class DimeState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 0.10 >= 0) {
            changeMaker.deductAmount(0.10);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Dime: " + count);
        }
        changeMaker.setState(new NickelState());
        changeMaker.startCalculate();
    }

}
