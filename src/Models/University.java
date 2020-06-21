package Models;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class University {
    public List<User> Users =new ArrayList();
    public List<Group> Groups =new ArrayList();
    public University() throws IOException {
        fillDummyData();
    }


    @Override
    public String toString() {
        return "University{" +
                "Users=" + Users +
                ", Groups=" + Groups +
                '}';
    }
    public void fillDummyData() throws IOException {
        User userOne = new Student("Abdul","Sheikhsalem",LocalDate.of(1993,3,30),
                "Abdul" ,"test");
        User userTwo = new Student("Willem","De vries",LocalDate.of(1992,3,30),
                "Abdul" ,"test");
        User userThree= new Teacher("Shuker","Barbour",LocalDate.of(1989,01,01),
                "Shuker","test2",(double)50);
        User userFour= new Teacher("Ram","Hamadani",LocalDate.of(1995,01,01),
                "Shuker","test2",(double)50);
        Group groupOne = new Group("group1");
        Users.add(userOne);
        Users.add(userTwo);
        Users.add(userThree);
        Users.add(userFour);
        groupOne.addStudent((Student) userOne);
        Groups.add(groupOne);
    }
}
