package homework;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    SharedMemory memory;
    ExplorationMap map;
    List<Robot> robots;
    boolean running;
    private int numRobotsFinished;
    private long startTime;
    private long endTime;


    public Exploration(int n) {
        this.memory = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>();
        this.running = false;
        this.numRobotsFinished = 0;


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

    public void stop() {//stopping all the robots in the list
        for (Robot robot : robots) {
            robot.stop();
        }
    }

    public void start() {
        synchronized (this) {
            if (running) {
                System.out.println("Exploration is already running");
                return;
            }
            running = true;
            startTime = System.currentTimeMillis(); // record start time
            for (Robot robot : robots) {
                new Thread(robot).start();
            }
            System.out.println("Exploration started");
            TimeKeeper timeKeeper = new TimeKeeper(40000, this);
            timeKeeper.start();
        }
    }

    public void startRobot(String name) {//starting a specified robot
        synchronized (this) {
            if (!running) {
                System.out.println("Exploration is not running");
                return;
            }
            boolean found = false;
            for (Robot robot : robots) {
                if (robot.getName().equals(name)) {
                    robot.setPaused(false);
                    System.out.println("Robot " + name + " started");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Robot not found");
            }
        }
    }

    public void pause(int seconds) { //pause the exploration for a specified number of seconds
        running = false;
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exploration is paused for " + seconds + " seconds");
        running = true;
    }

    public void pauseRobot(int seconds, String robotName) {//pause a robot for a specified number of seconds
        synchronized (this) {
            if (!running) {//checking if the exploration is running
                System.out.println("Exploration is not running");
                return;
            }
            if (robotName != null) {//looking for the specified name in the list
                Robot robotToPause = null;
                for (Robot robot : robots) {
                    if (robot.getName().equals(robotName)) {
                        robotToPause = robot;
                        break;
                    }
                }
                if (robotToPause == null) {//if the specified robot is not found
                    System.out.println(robotName + "not found");
                    return;
                }
                robotToPause.stop();
                try {//pausing the robot for the specified number of seconds
                    Thread.sleep(seconds * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //creating a new Robot object with the same name as the paused robot
                robotToPause = new Robot(robotToPause.getName(), this);
                //creating a new thread for the new robot
                Thread newThread = new Thread(robotToPause);
                //replacing the existing robot with the new one in the list
                robots.set(robots.indexOf(robotToPause), robotToPause);
                newThread.start();
                System.out.println("Robot " + robotName + "is paused for " + seconds + " seconds");
            }
        }
    }


    public void reportTokensPlaced() {
        System.out.println("Tokens placed:");
        for (Robot robot : robots) {
            System.out.println(robot.getName() + ": " + robot.getNumTokensPlaced());
        }
    }


}
