package homework;

public class Main extends Thread {
    public static void main(String args[]) {

        var explore = new Exploration(15);
        explore.addRobot(new Robot("Wall-e", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        RobotCommand command = new RobotCommand(explore);
        command.start();
    }
}
