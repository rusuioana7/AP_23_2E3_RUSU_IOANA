package compulsory;

public class Main extends Thread {
    public static void main(String args[]) {

        var explore = new Exploration(3);
        explore.addRobot(new Robot("Wall-e", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        explore.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        explore.stop();
        }

}
