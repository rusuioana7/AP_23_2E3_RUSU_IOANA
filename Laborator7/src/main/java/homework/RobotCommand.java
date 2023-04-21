package homework;

import java.util.Scanner;

public class RobotCommand {
    private final Exploration exploration;

    public RobotCommand(Exploration exploration) {
        this.exploration = exploration;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {//a while loop that waits for the user's input
            System.out.println("Enter a command:");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "start all"://starting all the robots
                    exploration.start();//start the exploration
                    break;
                case "pause all"://pausing all the robots
                    System.out.print("Enter pause time in seconds: ");
                    int pauseTimeAll = scanner.nextInt();
                    scanner.nextLine();
                    exploration.pause(pauseTimeAll);
                    break;
                case "start"://start a specified robot
                    System.out.print("Enter robot name: ");
                    String name = scanner.nextLine();
                    exploration.startRobot(name);
                    break;
                case "pause"://pausing a specified robot for a specified number of seconds
                    System.out.print("Enter robot name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter pause time in seconds: ");
                    int pauseTime = scanner.nextInt();
                    scanner.nextLine();
                    exploration.pauseRobot(pauseTime, name);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

}

