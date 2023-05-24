package homework;


class Timer {
    private int remainingTime; // Remaining time in seconds
    private long lastMoveTime;
    private boolean isRunning;
    private boolean isTimeUp;
    private int initialTime;
    private Thread timerThread;

    public Timer(int initialTime) {
        this.remainingTime = initialTime;
        this.isRunning = false;
        this.initialTime = initialTime;
        this.isTimeUp = false;
    }

    public void start() {
        this.timerThread = new Thread(() -> {
            try {
                while (remainingTime > 0) {
                    Thread.sleep(1000); // Sleep for 1 second
                    remainingTime -= 1000; // Decrease remaining time by 1 second
                    System.out.println("Time remaining: " + remainingTime / 1000 + " seconds");
                }
                System.out.println("Time's up!");
            } catch (InterruptedException e) {
                // Handle the InterruptedException
                System.out.println("Timer thread interrupted!");
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        });

        timerThread.start();
    }


    public boolean isTimeUp() {
        return isTimeUp;
    }

    public int getRemainingTime(Player nextPlayer) {
        return remainingTime;
    }


    public synchronized void deductElapsedTime(Player player) {
        int elapsedSeconds = calculateElapsedSeconds();
        remainingTime -= elapsedSeconds;
        lastMoveTime = System.currentTimeMillis();
    }

    private int calculateElapsedSeconds() {
        long currentTime = System.currentTimeMillis();
        int elapsedSeconds = (int) ((currentTime - lastMoveTime) / 1000);
        return elapsedSeconds;
    }


    public void stop() {
        if (isRunning) {
            isRunning = false;
            timerThread.interrupt();
        }
    }


}