package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Network {
    private List<Node> nodes = new ArrayList<>(); //list of identifiable nodes

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }


    public int getImportanceOfPerson(Node node) { //method for finding the importance(number of connections) of a node
        int importanceOfPerson = 0; //the variable
        if (node instanceof Person) //checking if the object is an instance of class Person
            importanceOfPerson = ((Person) node).getRelationships().size(); //getting the number of relationships
        for (Node person : nodes) //for each node
            if (person instanceof Person) {
                Iterator<Map.Entry<Node, String>> contor = ((Person) person).getRelationships().entrySet().iterator(); //using an iterator to iterate over the map entries of the relationships associated with the object.
                Map.Entry<Node, String> entry = contor.next(); //getting the next map entry
                Node key = entry.getKey(); //storing in key the other end of the object's relationship
                if (key.getName().equals(node.getName())) { //comparing the key with the object
                    importanceOfPerson++; //if they are equal there is a connection
                }

            }
        return importanceOfPerson;
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }


}


