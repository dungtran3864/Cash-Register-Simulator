import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class TextReader {

    private BillsCounter billsCounter;

    public TextReader(BillsCounter billsCounter) {
        this.billsCounter = billsCounter;
    }

    public void initializeReading() {
        try {
            File file = new File("db/bills.txt");
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitString = line.split("\\s+");
                this.billsCounter.addBill(splitString[0], Integer.parseInt(splitString[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
