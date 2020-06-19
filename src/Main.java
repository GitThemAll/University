import Models.University;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public  University u;



    @Override
      public void start(Stage primaryStage) throws Exception{
        u= University.getInstance();
        Parent root = FXMLLoader.load(getClass().getResource("Resources/Views/Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
