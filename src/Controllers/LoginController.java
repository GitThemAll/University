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
public class LoginController {
    University u= University.getInstance();
    @FXML
    private TextField UsernameTextfield;

    @FXML
    private TextField PasswordTextfield;

    public LoginController() throws IOException {
    }

    public void login(MouseEvent mouseEvent) {
       boolean auth= authenticateUser();
       if (!auth)
       {
           UsernameTextfield.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
           PasswordTextfield.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
       };

    }
    private boolean authenticateUser(){
        String username= UsernameTextfield.getText();
        String password= PasswordTextfield.getText();
        for (User user : u.Users)
        {
            if (user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}