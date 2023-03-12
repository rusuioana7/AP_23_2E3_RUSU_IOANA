package compulsory;
import java.util.ArrayList;


public class Person implements Node, Comparable<Person> {
        private String name;
        private String company;
        private String position;
        private String specialization;

        public Person(String name, String company , String position, String specialization) {
            this.name = name;
            this.company = company;
            this.position = position;
            this.specialization = specialization;


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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

}
