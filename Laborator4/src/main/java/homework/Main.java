package homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Problem problem1 = new Problem();
        Faker faker1 = new Faker();
        Random random = new Random();
        int counter;

        //creating the student and project objects
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student(faker.name().firstName()))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.commerce().productName()))
                .toArray(Project[]::new);



        //adding the students to the list
        for (Student s : students) {
            problem1.addStudent(s);
        }
        System.out.println("Students:");
        problem1.getStudents();


        //adding the projects to the list
        for(Project p: projects){
            problem1.addProject(p);
        }
        System.out.println("\nProjects:");
        problem1.getProjects();


        for (Student s : problem1.students) {//creating the random admissible projects list for each student
            counter=0;
            List<Project> anotherList = new ArrayList<>(problem1.projects);

            while (counter < faker1.number().numberBetween(1, problem1.projects.size())) {
                Project randomProject = anotherList.get(random.nextInt(anotherList.size()));
                anotherList.remove(randomProject);

                if (randomProject != null) {
                    s.addPreference(randomProject);
                    counter++;

                }
            }
        }

        //sorting the students based on their number of preferences
        Collections.sort(problem1.students, (student1, student2) -> Integer.compare(student2.admissibleProjects.size(), student1.admissibleProjects.size()));


        //printing the results
        System.out.println("\nStudents sorted and their list of admissible projects:");
        problem1.students.forEach(student1 -> System.out.println(student1.getStudentName() + " - " + student1.admissibleProjects));

        System.out.println("\nStudents and their assigned project using the greedy algorithm:");
        problem1.greedyAlgorithm();

        System.out.println("\nStudents with number of project preferences lower than the average number of preferences:");
        problem1.studentsWithLowPreference();



    }


}