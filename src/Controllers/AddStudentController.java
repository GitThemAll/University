package Controllers;

import Models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

import java.io.IOException;
import java.time.LocalDate;

public class AddStudentController extends MainController{

    @FXML
    private TextField NewStudentUsername;

    @FXML
    private TextField NewStudentBirthdate;

    @FXML
    private TextField NewStudentLastname;

    @FXML
    private TextField NewStudentPassword;

    @FXML
    private TextField NewStudentFirstname;

    @FXML
    private Button NewStudentAddStudent;

    @FXML
    private Label UserText;

    @FXML
    private Button NewStudentCancelBTN;

    @FXML
    void AddNewStudent(MouseEvent event) throws IOException {
        this.UserText.setText("");
        String username = NewStudentUsername.getText();
        String firstname = NewStudentFirstname.getText();
        String lastname = NewStudentLastname.getText();
        String password = NewStudentPassword.getText();
        LocalDate birthdate =LocalDate.now();
        try{
         birthdate = LocalDate.parse(NewStudentBirthdate.getText());
        }
        catch (Exception e ){
          this.UserText.setText("please provide a valid date format (eg 2016-30-03)");
          this.UserText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
          return;
        }
        Student newStudent= new Student(firstname,lastname,birthdate,username,password);
        this.dataInstance.Users.add(newStudent);
        this.UserText.setText("A new Student is Added");

    }

    @FXML
    void CancelNewStudent(MouseEvent event) throws IOException {
        SwitchScene("mainview");
    }

}
