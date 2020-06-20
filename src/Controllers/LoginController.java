package Controllers;

import Models.University;
import Models.User;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Controls the login screen
 */
public class LoginController extends MainController {
    @FXML
    private TextField UsernameTextfield;

    @FXML
    private TextField PasswordTextfield;




    public void login(MouseEvent mouseEvent) throws IOException {
       boolean auth= authenticateUser();
       if (!auth)
       {
           UsernameTextfield.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
           PasswordTextfield.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
       }
       else{
           UsernameTextfield.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
           PasswordTextfield.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
           SwitchScene("mainview");
        }

    }
    private boolean authenticateUser(){
        String username= UsernameTextfield.getText();
        String password= PasswordTextfield.getText();
        for (User user : dataInstance.Users)
        {
            if (user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    assignUser(user);
                    return true;
                }
            }
        }
        return false;
    }


}