package compulsory;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<Student>();

        for (Student s : students) {
            listOfStudents.add(s);
        }

        Collections.sort(listOfStudents);
        for (Student s : listOfStudents) System.out.print(" " + s);

        Set<Project> listOfProjects = new TreeSet<>();
        for(Project p: projects){
            listOfProjects.add(p);
        }

        for (Project p : listOfProjects) System.out.print(" " + p);


    }


}