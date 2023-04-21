package homework;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    String name;
    boolean running;
    Exploration explore;
    Random random;
    SharedMemory tokenList;
    List<Token> extractedTokens;
    private boolean paused;
    private int numTokensPlaced;


    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running = true;
        this.random = new Random();
        this.tokenList = explore.getMemory();
        this.numTokensPlaced = 0;

    }


    public void stop() {
        this.running = false;
    }


    public void run() {
        while (running) {

            // check if there are unexplored squares
            if (explore.getMap().hasUnexploredCell()) {
                int[] nextSquare = explore.getMap().getUnexploredCell();
                int row = nextSquare[0];
                int column = nextSquare[1];
                // extract tokens
                int numberTokensToExtract = random.nextInt(3);
                extractedTokens = (List<Token>) tokenList.extractTokens(numberTokensToExtract);
                // visit the square
                explore.getMap().visit(row, column, this);
                numTokensPlaced += extractedTokens.size();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {

                }

            } else {
                // stop the exploration process after all the squares have been explored
                explore.stop();
                break;
            }
        }
    }

    public int getNumTokensPlaced() {
        return numTokensPlaced;
    }

    public void setPaused(boolean paused) {
        synchronized (this) {
            this.paused = paused;
            if (!paused) {
                notify();
            }
        }
    }


    public List<Token> getExtractedTokens() {
        return extractedTokens;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", running=" + running +
                ", explore=" + explore +
                ", random=" + random +
                ", tokenList=" + tokenList +
                ", extractedTokens=" + extractedTokens +
                '}';
    }
}
