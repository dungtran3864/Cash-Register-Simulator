import java.util.ArrayList;

public class QueueReader {

    private ArrayList<String> listOfBills;

    public QueueReader() {
        listOfBills = new ArrayList<>();
    }

    public void addBillsList(String string) {
        this.listOfBills.add(string);
    }

    public void noticeNotEnoughBills() {
        this.listOfBills = new ArrayList<>();
        this.listOfBills.add("You don't have enough denominations to give back!");
    }

    public ArrayList<String> getListOfBills() {
        return this.listOfBills;
    }

}
