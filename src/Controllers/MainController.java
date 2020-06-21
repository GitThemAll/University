package Controllers;

import Models.University;
import Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    protected   University dataInstance;
    protected User currentUser;
    protected String userRole;
    private Stage mainWindow ;




    public void SwitchScene(String sceneName) throws IOException {
        if(this.mainWindow==null)
        mainWindow= new Stage();
        if (dataInstance==null)
            dataInstance= new University();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(String.format("../Resources/Views/%s.fxml",sceneName)));
        Parent root = (Parent)fxmlLoader.load();
        MainController controller = fxmlLoader.<MainController>getController();
        controller.onit(mainWindow, dataInstance);

        if (currentUser!=null)
            controller.assignUser(currentUser);
        controller.setAccess();
        Scene scene = new Scene(root);
        mainWindow.setScene(scene);
        mainWindow.setTitle(sceneName);
        mainWindow.show();
    }

    protected void setAccess() {
    }


    public void onit(Stage mw, University data){
        this.mainWindow=mw;
        this.dataInstance= data;
    }
    public void assignUser(User u){
        this.currentUser=u;
        this.userRole=u.getClass().getName().split("\\.")[1];
    }

}
