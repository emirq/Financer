package Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

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
            alert.setHeaderText("Financer beta");
            alert.setContentText("Developed and designed by Benjamin Fajić "
                    + "and Emir Kurtanović\n\n2016 \u00a9 All rights reserved.");
 
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleTransaction (ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Income");
        choices.add("Expense");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Income", choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Chose wheter you want to record income or expense");
        dialog.setContentText("Choose your action:");

        // get result of choice dialog
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String choice = result.get(); // for example, handle it like this
            System.out.println("Your choice is " + choice);
        }
    }
}
