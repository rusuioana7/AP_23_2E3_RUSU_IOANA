package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Person implements Node, Comparable<Person> {
    private String name;
    private String company;
    private String birthDate;
    private Map<Node, String> relationships = new HashMap<>();

    public Person() {
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", relationships=" + relationships +
                '}';
    }

    public Person(String name, String company, String birthDate) {
        this.name = name;
        this.company = company;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public Node addRelationship(Node node, String value) {
        relationships.put(node, value);
        return node;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(company, person.company) && Objects.equals(birthDate, person.birthDate) && Objects.equals(relationships, person.relationships);
    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
