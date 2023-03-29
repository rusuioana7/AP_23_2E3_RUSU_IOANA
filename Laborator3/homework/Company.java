package homework;

import homework.Node;

import java.util.Objects;

public class Company implements Node, Comparable<Company> {
    private String name;
    private int numberOfProjects;
    private int numberOfEmployees;

    public Company(String name, int numberOfEmployees, int numberOfProjects) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfProjects = numberOfProjects;

    }

    public Company() {
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", numberOfProjects=" + numberOfProjects +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return numberOfProjects == company.numberOfProjects && numberOfEmployees == company.numberOfEmployees && Objects.equals(name, company.name);
    }


    @Override
    public int compareTo(Company o) {
        return 0;
    }
}

