package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
   private List<Student> Students= new ArrayList();
   private String Name;

    public Group(String name) {
        Name = name;
    }

    public Group() {
    }

    public void addStudent(Student student){
       this.Students.add(student);
   }
    public void removeStudent(Student student){
       this.Students.remove(student);
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = String.format("Group: %s.",name) ;
    }

    @Override
    public String toString() {
        return "Group{" +
                "Students=" + Students +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(Students, group.Students) &&
                Objects.equals(Name, group.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Students, Name);
    }
}

