package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;

public class Student extends User{

    public HashMap<String, Double> scores = new java.util.HashMap<String, Double>();
    public Student(String firstname, String lastname, LocalDate birthDate, String username, String password) throws IOException {
        super(firstname, lastname, birthDate, username, password);
        fillScores();
    }

    @Override
    public String toString() {
        return ("User{" +
                "Id=" + this.getId() +
                ", Firstname='" + this.getFirstname() + '\'' +
                ", Lastname='" + this.getLastname() + '\'' +
                ", BirthDate=" + this.getBirthDate() +
                ", Username='" + this.getUsername() + '\'' +
                ", Age=" + this.getAge());
    }


    private void fillScores() throws IOException {
        String filePath= String.format("%s/src/Models/subjects.txt",Paths.get(".").toAbsolutePath().normalize().toString()) ;
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null)
        {
            String key = line;
            this.scores.put(key, (double) 0);
        }
        reader.close();
    }

    private void changeScore(String subject, Double score){
        this.scores.put(subject, score);
    }
}
