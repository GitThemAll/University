package Models;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class University {
    private static University UniversityInstance= null;
    public List<User> Users =new ArrayList();
    public List<Group> Groups =new ArrayList();
    private University() throws IOException {
        fillDummyData();
    }

    public static University getInstance() throws IOException {
        if (UniversityInstance == null)
            UniversityInstance = new University();
        return UniversityInstance;
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
        User userTwo= new Teacher("Shuker","Barbour",LocalDate.of(1993,01,01),
                "Shuker","test2",(double)50);
        Group groupOne = new Group("group1");
        Users.add(userOne);
        Users.add(userTwo);
        groupOne.addStudent((Student) userOne);
        Groups.add(groupOne);
    }
}
