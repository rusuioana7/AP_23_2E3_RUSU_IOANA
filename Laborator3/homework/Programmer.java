package homework;

public class Programmer extends Person {
    private int numberOfKnownLanguages;
    private int numberOfCurrentProjects;

    public Programmer(String name, String company, String birthDate, int numberOfKnownLanguages, int numberOfCurrentProjects) {
        super(name, company, birthDate);
        this.numberOfKnownLanguages = numberOfKnownLanguages;
        this.numberOfCurrentProjects = numberOfCurrentProjects;
    }

    public void setNumberOfKnownLanguages(int numberOfKnownLanguages) {
        this.numberOfKnownLanguages = numberOfKnownLanguages;
    }

    public int getNumberOfKnownLanguages() {
        return numberOfKnownLanguages;
    }

    public int getNumberOfCurrentProjects() {
        return numberOfCurrentProjects;
    }

    public void setNumberOfCurrentProjects(int numberOfCurrentProjects) {
        this.numberOfCurrentProjects = numberOfCurrentProjects;
    }
}
