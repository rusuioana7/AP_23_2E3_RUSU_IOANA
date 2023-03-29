package homework;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String studentName;
    List<Project> admissibleProjects = new ArrayList<Project>(); //list of admissible projects

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {//generating random names for students using javafaker
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void addPreference(Project project) {//adding student's project preferences
        admissibleProjects.add(project);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentName, student.studentName);
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
