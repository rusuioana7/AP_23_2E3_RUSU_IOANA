package compulsory;

import java.util.ArrayList;
import java.util.List;

import compulsory.Person;
import compulsory.Company;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Person person1 = new Person("Ioana", "Google", "software developer", "testing");
        Person person2 = new Person("Elena", "Google", "software developer", "graphs");
        Company company1 = new Company("Google");

        nodes.add(person1);
        nodes.add(person2);
        nodes.add(company1);


        System.out.println(nodes);


    }
}