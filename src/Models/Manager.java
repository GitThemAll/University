package Models;

import java.time.LocalDate;

public class Manager extends User {
    public Manager(String firstname, String lastname, LocalDate birthDate, String username, String password) {
        super(firstname, lastname, birthDate, username, password);
    }
}
