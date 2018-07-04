public class TwoState  implements State {

    private int count = 0;

    public void calculateCurrency(ChangeMaker changeMaker) {
        while (changeMaker.getAmount() - 2 >= 0) {
            changeMaker.deductAmount(2);
            this.count += 1;
        }
        if (count != 0) {
            System.out.println("$2 bills: " + count);
        }
        changeMaker.setState(new OneState());
        changeMaker.startCalculate();
    }

}
