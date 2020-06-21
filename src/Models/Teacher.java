package Models;

import java.time.LocalDate;

public class Teacher extends User {
    private Double Salary;

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public Teacher(String firstname, String lastname, LocalDate birthDate, String username, String password, Double salary) {
        super(firstname, lastname, birthDate, username, password);
        Salary = salary;
    }

    public Teacher(String firstname, String lastname, LocalDate birthDate, String username, String password) {
        super(firstname, lastname, birthDate, username, password);
    }

    @Override
    public String toString() {
        return ("User{" +
                "Id=" + this.getId() +
                ", Firstname='" + this.getFirstname() + '\'' +
                ", Lastname='" + this.getLastname() + '\'' +
                ", BirthDate=" + this.getBirthDate() +
                ", Username='" + this.getUsername() + '\'' +
                ", Age=" + this.getAge() +
                ", Salary=" + this.getSalary());
    }

}

