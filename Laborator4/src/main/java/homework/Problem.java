package homework;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutablePair;


//class Problem creates a maximum cardinality matching between students and projects
public class Problem {
    List<Student> students = new ArrayList<>();
    List<Project> projects = new ArrayList<>();
    List<MutablePair<String, String>> greedy = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void getStudents() {
        for (Student s : students) {
            System.out.print(s.toString() + " ");
        }
    }

    public void getProjects() {
        for (Project p2 : projects) {
            System.out.print(p2.toString() + " ");
        }
    }

    void studentsWithLowPreference() {//method used for determining the number of students who have a lower preference than average
        int numberOfProjectsPreffered = 0;//number of projects preferred
        for (Student s : students) {//for each student
            numberOfProjectsPreffered += s.admissibleProjects.size();
        }
        double avgPreference = (double) numberOfProjectsPreffered / students.size(); //calculating the average
        students.stream() //selecting the students with a lower project preference than average
                .filter(s -> s.admissibleProjects.size() < avgPreference)
                .forEach(s -> System.out.println(s.getStudentName()));
    }

    public void greedyAlgorithm() {//the method uses a greedy algorithm to assign each student a project
        List<Project> assignedProjects = new ArrayList<>(); //list created for keeping count of the already assigned projects as we're assigning
        for (Student student : this.students) {
            System.out.print(student.toString() + " is assigned ");
            for (Project project : student.admissibleProjects) {
                if (!assignedProjects.contains(project)) {//checking if the project has been already assigned
                    greedy.add(new MutablePair<>(student.getStudentName(), project.getProjectName()));//saving the student-project pair
                    assignedProjects.add(project);//updating the already assigned projects
                    System.out.println(project.toString());
                    break;

                }

            }
        }
    }
}
