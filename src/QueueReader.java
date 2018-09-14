import java.util.ArrayList;

public class QueueReader {

    private ArrayList<String> listOfBills;

    public QueueReader() {
        listOfBills = new ArrayList<>();
    }

    public void addBillsList(String string) {
        listOfBills.add(string);
    }

    public void printList() {
        for (String string : listOfBills) {
            System.out.println(string);
        }
    }

}
