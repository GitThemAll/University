package Controllers;


import Models.University;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/** Controls the main application screen */
public class MainViewController extends MainController {
    @FXML
    private ListView<User> mainList;

    @FXML
    private Button DisplayStudentBTN;

    @FXML
    private Button AddStudentBTN;

    @FXML
    private Button DisplayTeachersBTN;

    @FXML
    private Button ShowReportsBTN;

    @FXML
    private Button SaveRepotsBTN;

    @FXML
    void AddStudent(MouseEvent event) {

    }

    @FXML
    void Display(MouseEvent event) {
        ObservableList<User> users= FXCollections.observableArrayList(dataInstance.Users);
        mainList.setItems(users);
    }

    @FXML
    void SaveReports(MouseEvent event) {

    }
}