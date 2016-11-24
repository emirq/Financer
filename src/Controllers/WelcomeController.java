package Controllers;

import Helpers.ViewLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        viewLoader = new ViewLoader("welcome");
        Parent welcome = viewLoader.load();

        primaryStage.setTitle("Welcome to Financer");
        primaryStage.setScene(new Scene(welcome, 600, 400));
        primaryStage.show();
    }

    @FXML
    private void goButtonClicked(ActionEvent event) {
        if (event.getSource() == goButton) {
            System.out.println("jeste to je taj button");
            System.out.println("jest al k");
        }
    }
}

