import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class GUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Change Calculator");

        // Create new calculator pane
        GridPane calPane = new GridPane();
        //Setting the padding
        calPane.setPadding(new Insets(10, 10, 10, 10));
        //Setting the vertical and horizontal gaps between the columns
        calPane.setVgap(5);
        calPane.setHgap(5);

        //Setting the Grid alignment
        calPane.setAlignment(Pos.CENTER);

        Label costTotalLabel = new Label("Enter total cost: ");
        TextField costInput = new TextField();
        calPane.add(costTotalLabel, 0, 0);
        calPane.add(costInput, 1, 0);

        Label inputStartLabel = new Label("Input the number of each U.S denomination you receive");
        // Skip some rows in order to create space between total cost input and denomination inputs
        calPane.add(inputStartLabel, 0, 4);
        GridPane.setColumnSpan(inputStartLabel, 4);

        Label hundredLabel = new Label("$100");
        TextField hundredInput = new TextField();
        calPane.add(hundredLabel, 0, 5);
        calPane.add(hundredInput, 1, 5);

        Label fiftyLabel = new Label("$50");
        TextField fiftyInput = new TextField();
        calPane.add(fiftyLabel, 0, 6);
        calPane.add(fiftyInput, 1, 6);

        Label twentyLabel = new Label("$20");
        TextField twentyInput = new TextField();
        calPane.add(twentyLabel, 0, 7);
        calPane.add(twentyInput, 1, 7);

        Label tenLabel = new Label("$10");
        TextField tenInput = new TextField();
        calPane.add(tenLabel, 0, 8);
        calPane.add(tenInput, 1, 8);

        Label fiveLabel = new Label("$5");
        TextField fiveInput = new TextField();
        calPane.add(fiveLabel, 0, 9);
        calPane.add(fiveInput, 1, 9);

        Label oneLabel = new Label("$1");
        TextField oneInput = new TextField();
        calPane.add(oneLabel, 0, 10);
        calPane.add(oneInput, 1, 10);

        Label quarterLabel = new Label("25¢");
        TextField quarterInput = new TextField();
        calPane.add(quarterLabel, 0, 11);
        calPane.add(quarterInput, 1, 11);

        Label dimeLabel = new Label("10¢");
        TextField dimeInput = new TextField();
        calPane.add(dimeLabel, 0, 12);
        calPane.add(dimeInput, 1, 12);

        Label nickelLabel = new Label("5¢");
        TextField nickelInput = new TextField();
        calPane.add(nickelLabel, 0, 13);
        calPane.add(nickelInput, 1, 13);

        Label pennyLabel = new Label("1¢");
        TextField pennyInput = new TextField();
        calPane.add(pennyLabel, 0, 14);
        calPane.add(pennyInput, 1, 14);

        Button calculateButton = new Button();
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                double cost = Double.parseDouble(costInput.getText());
                cost = Math.round(cost * 100.0) / 100.0;

                HashMap<String, Integer> listOfDenominations = gatherDenominationInputs();
                PayerBills payerBills = new PayerBills(listOfDenominations);
                double paid = payerBills.getPaid();
                paid = Math.round(paid * 100.0) / 100.0;

                ChangeCalculator changeCalculator = new ChangeCalculator(cost, paid, payerBills.getBillsCounter());
                BigDecimal totalChange = changeCalculator.getAmount();

                changeCalculator.startCalculate();
                ArrayList<String> listOfBills = changeCalculator.getListOfBills();

                GridPane resultPane = new GridPane();
                resultPane.setVgap(5);
                resultPane.setHgap(5);
                resultPane.setPadding(new Insets(10, 10, 10, 10));
                resultPane.setAlignment(Pos.CENTER);

                Label totalCostLabel = new Label("Total cost: $" + cost);
                Label totalPaidLabel = new Label("Total paid: $" + paid);
                Label totalChangeLabel = new Label("Total change: $" + totalChange.toString());
                resultPane.add(totalCostLabel,0,0);
                resultPane.add(totalPaidLabel,0,1);
                resultPane.add(totalChangeLabel,0,2);

                Label noticeChangeLabel = new Label("Denominations to give back");
                resultPane.add(noticeChangeLabel,0,5);

                int rowIdx = 6;

                for (String bill : listOfBills) {
                    Label billLabel = new Label(bill);
                    resultPane.add(billLabel, 0, rowIdx);
                    rowIdx += 1;
                }

                Scene resultScene = new Scene(resultPane, 350, 350);
                primaryStage.setScene(resultScene);
            }

            private HashMap<String, Integer> gatherDenominationInputs() {
                HashMap<String, Integer> listOfDenominationInputs = new HashMap<>();
                int hundred = acquireInput(hundredInput.getText());
                listOfDenominationInputs.put("Hundred", hundred);
                int fifty = acquireInput(fiftyInput.getText());
                listOfDenominationInputs.put("Fifty", fifty);
                int twenty = acquireInput(twentyInput.getText());
                listOfDenominationInputs.put("Twenty", twenty);
                int ten = acquireInput(tenInput.getText());
                listOfDenominationInputs.put("Ten", ten);
                int five = acquireInput(fiveInput.getText());
                listOfDenominationInputs.put("Five", five);
                int one = acquireInput(oneInput.getText());
                listOfDenominationInputs.put("One", one);
                int quarter = acquireInput(quarterInput.getText());
                listOfDenominationInputs.put("Quarter", quarter);
                int dime = acquireInput(dimeInput.getText());
                listOfDenominationInputs.put("Dime", dime);
                int nickel = acquireInput(nickelInput.getText());
                listOfDenominationInputs.put("Nickel", nickel);
                int penny = acquireInput(pennyInput.getText());
                listOfDenominationInputs.put("Penny", penny);
                return listOfDenominationInputs;
            }

            private int acquireInput(String input) {
                if (input != null) {
                    if (!input.trim().equals("")) {
                        return Integer.parseInt(input);
                    }
                }
                return 0;
            }

        });
        calculateButton.setText("Calculate Change");
        calPane.add(calculateButton, 1, 17);

        Scene scene = new Scene(calPane, 370, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
