public class PennyState implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 0.01 >= 0) {
            changeMaker.deductAmount(0.01);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("Penny: " + count);
        }
    }

}
