package Controllers;


import Models.Student;
import Models.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/** Controls the main application screen */
public class MainViewController extends MainController implements Initializable {
    private List<User> students ;
    private List<User> teachers ;

    @FXML
    private javafx.scene.control.ListView<Report> ReportsListView;

    @FXML
    private javafx.scene.control.TableView<User> UsersTableView;

    @FXML
    private Button DisplayStudentBTN;

    @FXML
    private Button AddStudentBTN;

    @FXML
    private Button DisplayTeachersBTN;

    @FXML
    private Button DisplayReportsBTN;

    @FXML
    private Button SaveReportsBTN;

    @FXML
    void AddStudent(MouseEvent event) throws IOException {
        SwitchScene("addStudent");
    }

    @FXML
    void DisplayStudents(MouseEvent event) {
        FillStudents();
        ObservableList<User> castedListStudents= FXCollections.observableArrayList(this.students);
        PopulateUsersTableView(castedListStudents);
    }
    void FillStudents(){
        if (this.students==null){
            this.students= new  ArrayList();
            for (User u: dataInstance.Users){
                if(u.getClass().getName().split("\\.")[1].equals("Student")){
                    this.students.add(u);
                }
            }
        }
    }
    @FXML
    void SaveReports(MouseEvent event) {
        WriteReports();
    }

    public void DisplayReports(MouseEvent mouseEvent) {
        FillStudents();
        PopulateReportsTableView();

    }
    private void WriteReports(){
        ObservableList<Report> reports= MakeReportsList();
        for(Report r : reports)
        try {
            File myObj = new File(String.format("%s.txt",r.getName()));
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(myObj.getName());
            myWriter.write(r.Report);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void PopulateReportsTableView() {
        this.UsersTableView.setVisible(false);
        this.ReportsListView.setVisible(true);
        ObservableList<Report> reports = MakeReportsList();
        this.ReportsListView.setItems(reports);


    }
    private ObservableList<Report> MakeReportsList(){
        FillStudents();
        List<Student> castedStudentList= new ArrayList<Student>();
        ObservableList<Report> observableList = FXCollections.observableArrayList();
        for(User u: this.students){
            castedStudentList.add((Student) u);
        }
        for(Student s : castedStudentList){
            String report = extractReport(s);
            observableList.add(new Report(s.getFirstname(),report));
        }
        return observableList;
    }
    private String extractReport(Student s){
        String subject= "{%s : %s}" ;
        String fullReport= new String();
        for (Map.Entry<String, Double> item : s.scores.entrySet()) {
          fullReport+= String.format(subject, item.getKey(), item.getValue()) ;
        }
        return fullReport;
    }

    public void DisplayTeachers(MouseEvent mouseEvent) {
        FillTeachers();
        ObservableList<User> castedListTeachers= FXCollections.observableArrayList(this.teachers);
        PopulateUsersTableView(castedListTeachers);
    }

    private void FillTeachers() {
        if (this.teachers==null){
            this.teachers= new  ArrayList();
            for (User u: dataInstance.Users){
                if(u.getClass().getName().split("\\.")[1].equals("Teacher")){
                    this.teachers.add(u);
                }
            }
        }
    }

    public void PopulateUsersTableView(ObservableList<User> o){
        this.UsersTableView.getColumns().clear();
        this.ReportsListView.setVisible(false);
        this.UsersTableView.setVisible(true);
        Field[] superClassFields= o.get(0).getClass().getSuperclass().getDeclaredFields();
        for (Field f : superClassFields){
            if(!f.getName().equals("Password") && !f.getName().equals("next_id")){
            TableColumn tc= new TableColumn(f.getName());
            UsersTableView.getColumns().add(tc);
            tc.setCellValueFactory(new PropertyValueFactory<User, String>(f.getName()));
            }
        }
        Field[] fields = o.get(0).getClass().getDeclaredFields();

        for (Field f : fields){
            if(!f.getName().equals("Scores")) {
                TableColumn tc = new TableColumn(f.getName());
                UsersTableView.getColumns().add(tc);
                tc.setCellValueFactory(new PropertyValueFactory<User, String>(f.getName()));
            }
        }
        UsersTableView.setItems(o);
        
    }

    @Override
    protected void setAccess() {
        super.setAccess();
        switch (userRole){
            case "Student":
                this.DisplayStudentBTN.setDisable(false);
                this.DisplayTeachersBTN.setDisable(false);
                this.DisplayReportsBTN.setDisable(false);
                this.SaveReportsBTN.setDisable(false);
                this.AddStudentBTN.setDisable(false);
                break;
            case "Teacher":
                this.AddStudentBTN.setDisable(false);
                this.DisplayStudentBTN.setDisable(false);
                this.DisplayTeachersBTN.setDisable(false);
                this.DisplayReportsBTN.setDisable(false);
            case "Manager":
                this.AddStudentBTN.setDisable(false);
                this.DisplayStudentBTN.setDisable(false);
                this.DisplayTeachersBTN.setDisable(false);
                this.DisplayReportsBTN.setDisable(false);
                this.SaveReportsBTN.setDisable(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private class Report{

        private  String Name;
        private  String Report;

        Report(String name, String report){
            this.Name = name;
            this.Report = report;
        }

        public String getName() {
            return Name;
        }


        public String getReport() {
            return Report;
        }

        public void setName(String cellOne) {
            Name = cellOne;
        }

        public void setReport(String cellTwo) {
            Report = cellTwo;
        }

        @Override
        public String toString() {
            return "{" +
                    "Name='" + Name + '\'' +
                    ", Report='" + Report + '\'' +
                    '}';
        }
    }

}