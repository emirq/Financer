package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * Created by sk4yb3n on 25/11/2016.
 */
public class DashboardController {

    @FXML
    private MenuItem fileClose;
    @FXML
    private MenuItem helpAbout;
    @FXML
    private Label balanceAmount; // balance:
    @FXML
    private Label bankAmount; // bank account:
    @FXML
    private Button transactionButton;
  

    @FXML
    private void handleMenuItem (ActionEvent event) {
        if (event.getSource() == fileClose) {
            System.exit(0);
        } else if (event.getSource() == helpAbout) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Financer");
            alert.setHeaderText("FINANCER beta");
            alert.setContentText("Developed and designed by Benjamin Fajić "
                    + "and Emir Kurtanović\n\n2016 \u00a9 All rights reserved.");
            alert.setGraphic(new ImageView(this.getClass().getResource("icon.png").toString()));
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleTransaction (ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Income");
        choices.add("Expense");

        ChoiceDialog<String> dialogChoice = new ChoiceDialog<>("Income", choices);
        dialogChoice.setTitle("Choice Dialog");
        dialogChoice.setHeaderText("Chose wheter you want to record income or expense");
        dialogChoice.setContentText("Choose your action:");

        // get result of choice dialog
        Optional<String> resultChoice = dialogChoice.showAndWait();
        if (resultChoice.isPresent()){
            String choice = resultChoice.get(); // for example, handle it like this
            if (choice.equals("Income")) {
                // Create the custom dialog.
                Dialog<Pair<String, String>> dialogIncome = new Dialog<>();
                dialogIncome.setTitle("Income Dialog");
                dialogIncome.setHeaderText("Please, input data of your transaction");

                // Set the icon (must be included in the project).
                //dialogIncome.setGraphic(new ImageView(this.getClass().getResource("icon.png").toString()));

                

                // Set the button types.
                ButtonType loginButtonType = new ButtonType("Confirm", ButtonData.OK_DONE);
                dialogIncome.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

                // Create the username and password labels and fields.
                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);

                TextField amountIncome = new TextField();
                amountIncome.setPromptText("0.00 KM");
                TextField descriptionIncome = new TextField();
                descriptionIncome.setPromptText("Juice, sandwich, etc.");
                

                grid.add(new Label("Amount of income:"), 0, 0);
                grid.add(amountIncome, 1, 0);
                grid.add(new Label("Description:"), 0, 1);
                grid.add(descriptionIncome, 1, 1);

                // Enable/Disable login button depending on whether a username was entered.
                Node loginButton = dialogIncome.getDialogPane().lookupButton(loginButtonType);
                loginButton.setDisable(true);

                // Do some validation (using the Java 8 lambda syntax).
                amountIncome.textProperty().addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                });

                dialogIncome.getDialogPane().setContent(grid);

                // Request focus on the username field by default.
                Platform.runLater(() -> amountIncome.requestFocus());

                // Convert the result to a username-password-pair when the login button is clicked.
                dialogIncome.setResultConverter(dialogButton -> {
                    if (dialogButton == loginButtonType) {
                        return new Pair<>(amountIncome.getText(), descriptionIncome.getText());
                    }
                    return null;
                });

                Optional<Pair<String, String>> resultIncome = dialogIncome.showAndWait();

                resultIncome.ifPresent(usernamePassword -> {
                    String salary = usernamePassword.getKey();
                    balanceAmount.setText(salary);
                    //System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
                });
                
                /*TextInputDialog dialogIncome = new TextInputDialog();
                dialogIncome.setTitle("Income info");
                dialogIncome.setHeaderText("Please, input data of your transaction");
                //dialogIncome.setGraphic(new ImageView(this.getClass().getResource("@../images/icon.png").toString()));
                dialogIncome.setContentText("Amount:");

                // handle input
                Optional<String> resultIncome = dialogIncome.showAndWait();
                if (resultIncome.isPresent()){
                    System.out.println("Your name: " + resultIncome.get());
                }*/
            } else if (choice.equals("Expense")) {
                
            }
        }
    }
}
