package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        //creating Person and Company objects
        Person ioana = new Designer("Ioana", "Centric", "07.01.2003", 1, 2);
        Person elena = new Programmer("Elena", "Bitdefender", "08.07.2002", 2, 2);
        Company bitdefender = new Company("Bitdefender", 150, 10);
        Company centric = new Company("Centric", 50, 3);

        //adding relationships between objects
        ioana.addRelationship(elena, "bestfriend");
        ioana.addRelationship(centric, "boss");
        elena.addRelationship(ioana, "bestfriend");
        elena.addRelationship(bitdefender, "boss");

        Network network1 = new Network(nodes);
        //Comparator implemented for comparing object1 and object2(2 Node objects) based on their importance
        Comparator<Node> compareByImportance = (object1, object2) -> Integer.compare(network1.getImportanceOfPerson(object2), network1.getImportanceOfPerson(object1));

        //adding objects to the list
        nodes.add(ioana);
        nodes.add(elena);
        nodes.add(bitdefender);
        nodes.add(centric);


        System.out.println(nodes);
        System.out.println(network1.getImportanceOfPerson(ioana));

        nodes.sort(compareByImportance);
        System.out.println(network1);


    }
}