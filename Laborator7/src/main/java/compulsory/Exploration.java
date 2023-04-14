package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    SharedMemory memory;
    ExplorationMap map;
    List<Robot> robots;

    public Exploration(int n) {
        this.memory = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>();
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public SharedMemory getMemory() {
        return memory;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public void stop() {
        for (Robot robot : robots) {
            robot.stop();
        }
    }

}
