package Models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class User {
    private static int next_id = 0;   // <-- static, class-wide counter
    private int Id;
    private String Firstname;
    private String Lastname;
    private LocalDate BirthDate;
    private String Username;
    private String Password;
    private int Age;

    public User(String firstname, String lastname, LocalDate birthDate, String username, String password) {
        Id=++next_id;
        Firstname = firstname;
        Lastname = lastname;
        BirthDate = birthDate;
        Username = username;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public int getAge() {
        if ((this.BirthDate != null) && ( LocalDate.now()!= null)) {
            return Period.between(this.BirthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public void setId(int id) {
        Id = id;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", BirthDate=" + BirthDate +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Age=" + Age +
                '}';
    }
}
