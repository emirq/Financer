import Helpers.ViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewLoader viewLoader = new ViewLoader("welcome");
        Parent welcome = viewLoader.load();

        primaryStage.setTitle("Welcome to " + Config.APP_NAME);

        Scene welcomeScene = new Scene(welcome, 600, 400);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
