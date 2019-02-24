import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;

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

    public void writeFile() {
        HashMap<String, Integer> bills = this.billsCounter.getBillsCounter();
        try {
            File file = new File("db/bills.txt");
            FileWriter fileWriter = new FileWriter(file, false);
            Iterator it = bills.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();
                fileWriter.write(pair.getKey() + " " + pair.getValue() + "\n");
                it.remove(); // avoids a ConcurrentModificationException
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
