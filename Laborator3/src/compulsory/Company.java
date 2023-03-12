package compulsory;
import java.util.ArrayList;

public class Company implements Node, Comparable<Company> {
    private String name;
    public Company(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
