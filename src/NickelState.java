public class NickelState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 0.05 >= 0) {
            changeMaker.deductAmount(0.05);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Nickel: " + count);
        }
        changeMaker.setState(new PennyState());
        changeMaker.startCalculate();
    }

}
