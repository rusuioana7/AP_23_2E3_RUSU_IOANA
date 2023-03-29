package homework;

public class Designer extends Person {
    private int yearsOfExperience;
    private int knownPrograms;

    public Designer(String name, String company, String birthDate, int yearsOfExperience, int knownPrograms) {
        super(name, company, birthDate);
        this.yearsOfExperience = yearsOfExperience;
        this.knownPrograms = knownPrograms;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getKnownPrograms() {
        return knownPrograms;
    }

    public void setKnownPrograms(int knownPrograms) {
        this.knownPrograms = knownPrograms;
    }
}
