package Models;

import java.time.LocalDate;

public class Teacher extends User {
    private Double Salary;

    public Teacher(String firstname, String lastname, LocalDate birthDate, String username, String password, Double salary) {
        super(firstname, lastname, birthDate, username, password);
        Salary = salary;
    }

    public Teacher(String firstname, String lastname, LocalDate birthDate, String username, String password) {
        super(firstname, lastname, birthDate, username, password);
    }
}
