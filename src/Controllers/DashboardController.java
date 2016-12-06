package Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
    private MenuItem editCategories;
    @FXML
    private MenuItem addCategory;
    @FXML 
    private MenuItem removeCategory;
    @FXML
    private Label balanceAmount; // balance:
    @FXML
    private Label bankAmount; // bank account:
    @FXML
    private Button transactionButton;
    @FXML
    private Label amountInfo;
    @FXML
    private Label dateInfo;
    @FXML
    private Label walletBank;
    @FXML
    private Label descriptionInfo;
    
    private String radioToggled;
    Categories categories = new Categories();

    @FXML
    private void handleMenuItem (ActionEvent event) {
        if (event.getSource() == fileClose) {
            System.exit(0);
        } else if (event.getSource() == editCategories) {
            Alert categoriesInfoDialog = new Alert(Alert.AlertType.INFORMATION);
            categoriesInfoDialog.setTitle("Categories");
            categoriesInfoDialog.setHeaderText("Income and Expense Categories");
            categoriesInfoDialog.setGraphic(new ImageView(this.getClass().getResource("../images/icon.png").toString()));
               
            categoriesInfoDialog.setContentText("INCOME\n" + categories.incomeToString() 
                  + "\n\n\nEXPENSE\n" + categories.expenseToString());
            
            categoriesInfoDialog.showAndWait();
        } else if (event.getSource() == addCategory) {
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
            
                    TextInputDialog dialogAdd = new TextInputDialog();
                    dialogAdd.setTitle("Input Dialog");
                    dialogAdd.setHeaderText("Enter name for your category");
                    dialogAdd.setGraphic(new ImageView(this.getClass().getResource("../images/icon.png").toString()));

                    // Traditional way to get the response value.
                    Optional<String> result = dialogAdd.showAndWait();
                    if (result.isPresent()){
                        categories.addIncomeCategory(result.get());
                    }
                }
            }
        } else if (event.getSource() == removeCategory){ 
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
            
                    TextInputDialog dialogAdd = new TextInputDialog();
                    dialogAdd.setTitle("Input Dialog");
                    dialogAdd.setHeaderText("Enter name for your category");
                    dialogAdd.setGraphic(new ImageView(this.getClass().getResource("../images/icon.png").toString()));

                    // Traditional way to get the response value.
                    Optional<String> result = dialogAdd.showAndWait();
                    if (result.isPresent()){
                        categories.removeIncomeCategory(result.get());
                    }
                }
            }
        } else if (event.getSource() == helpAbout) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Financer");
            alert.setHeaderText("");
            alert.setContentText("beta\n\nDeveloped and designed by Benjamin Fajić "
                    + "and Emir Kurtanović\n\n2016 \u00a9 All rights reserved.");
            alert.setGraphic(new ImageView(this.getClass().getResource("../images/icon.png").toString()));
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
                dialogIncome.setGraphic(new ImageView(this.getClass().getResource("../images/icon.png").toString()));

                

                // Set the button types.
                ButtonType confirmButtonType = new ButtonType("Confirm", ButtonData.OK_DONE);
                dialogIncome.getDialogPane().getButtonTypes().addAll(confirmButtonType, ButtonType.CANCEL);

                // Create the amount and description labels and fields.
                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);

                TextField amountIncome = new TextField();
                amountIncome.setPromptText("0.00 KM");
                TextField descriptionIncome = new TextField();
                descriptionIncome.setPromptText("Salary, pocket money..");
                
                final ToggleGroup group = new ToggleGroup();
                group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    @Override
                    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                        if (group.getSelectedToggle() != null) {
                            //walletBank.setText(group.getSelectedToggle().getUserData().toString());
                        }

                    }
                });

                RadioButton rb1 = new RadioButton("Wallet");
                rb1.setUserData("Wallet");
                rb1.setToggleGroup(group);
                rb1.setSelected(true);

                RadioButton rb2 = new RadioButton("Bank");
                rb2.setUserData("Bank");
                rb2.setToggleGroup(group);
                
                grid.add(new Label("Amount"), 0, 0);
                grid.add(amountIncome, 1, 0);
                grid.add(new Label("Description:"), 0, 1);
                grid.add(descriptionIncome, 1, 1);
                grid.add(rb1, 1,3);
                grid.add(rb2, 1,4);

                // Enable/Disable login button depending on whether amount was entered.
                Node loginButton = dialogIncome.getDialogPane().lookupButton(confirmButtonType);
                loginButton.setDisable(true);

                // Do some validation (using the Java 8 lambda syntax).
                amountIncome.textProperty().addListener((observable, oldValue, newValue) -> {
                    loginButton.setDisable(newValue.trim().isEmpty());
                });

                dialogIncome.getDialogPane().setContent(grid);

                // Request focus on the amount field by default.
                Platform.runLater(() -> amountIncome.requestFocus());

                // Convert the result to a amount-description-pair when the confirm button is clicked.
                dialogIncome.setResultConverter(dialogButton -> {
                    if (dialogButton == confirmButtonType) {
                        return new Pair<>(amountIncome.getText(), descriptionIncome.getText());
                    }
                    return null;
                });

                Optional<Pair<String, String>> resultIncome = dialogIncome.showAndWait();

                resultIncome.ifPresent(amountAndDescription -> {
                    String amount = amountAndDescription.getKey();
                    String description = amountAndDescription.getValue();
                    balanceAmount.setText(amount);
                    amountInfo.setText(amount);
                    descriptionInfo.setText(description);
                    //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    //dateInfo.setText(dateFormat.format(new Date().toString()); //2016/11/16 12:08:43
                    dateInfo.setText(new Date().toString());
                    walletBank.setText(group.getSelectedToggle().getUserData().toString());
                });
                
            } else if (choice.equals("Expense")) {
                
            }
        }
    }
    
    
}
