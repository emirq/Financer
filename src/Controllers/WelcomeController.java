package Controllers;

import Helpers.ViewLoader;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by sk4yb3n on 23/11/2016.
 */
public class WelcomeController extends Application {

    private ViewLoader viewLoader;
    public Label welcomeLabel;
    public Button goButton;
    private Stage stage;
    private Scene welcomeScene, dashboardScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        viewLoader = new ViewLoader("welcome");
        Parent welcome = viewLoader.load();

        stage.setTitle("Welcome to Financer");

        welcomeScene = new Scene(welcome, 600, 400);
        stage.setScene(welcomeScene);
        stage.show();
    }

    @FXML
    private void goButtonClicked(ActionEvent event) throws Exception {
        viewLoader = new ViewLoader("dashboard");
        Parent dashboard = viewLoader.load();

        dashboardScene = new Scene(dashboard, 600, 400);
        Stage dashboardStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dashboardStage.setScene(dashboardScene);
        dashboardStage.show();
       /* if (event.getSource() == goButton) {
            viewLoader = new ViewLoader("dashboard");
            Parent dashboard = viewLoader.load();

            dashboardScene = new Scene(dashboard, 600, 400);
            stage.setScene(dashboardScene);
            stage.show();
        }*/
    }
}

