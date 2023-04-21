package homework;

public class TimeKeeper extends Thread {
    private final long timeLimit;
    private final Exploration explore;

    public TimeKeeper(long timeLimit, Exploration explore) {
        this.timeLimit = timeLimit;
        this.explore = explore;
        setDaemon(true);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeLimit) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println((System.currentTimeMillis() - startTime) / 1000 + " seconds");
        }
        System.out.println("Time limit of " + timeLimit / 1000 + " seconds exceeded");
        explore.reportTokensPlaced();
        explore.stop();

    }
}

