package compulsory;

import java.util.Objects;

public class Project implements Comparable<Project> {
    private String projectName;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName);
    }





    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Project o) {
        return 0;
    }
}
