package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private void handleMenuItem (ActionEvent event) {
        if (event.getSource() == fileClose) {
            System.exit(0);
        } else if (event.getSource() == helpAbout) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Financer");
            alert.setHeaderText(null);
            alert.setContentText("Financer beta \u00a9 All rights reserved."
                    + "\n\nDeveloped and designed by Benjamin Fajić and Emir Kurtanović.");
 
            alert.showAndWait();
        }
    }
}
