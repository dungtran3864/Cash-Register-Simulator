import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        calculateButton.setText("Calculate Change");
        calPane.add(calculateButton, 1, 17);

        Scene scene = new Scene(calPane, 370, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
