import Controllers.LoginController;
import Controllers.MainController;
import Models.University;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
      public void start(Stage primaryStage) throws Exception{
        MainController mainController= new MainController();
        mainController.SwitchScene("Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
