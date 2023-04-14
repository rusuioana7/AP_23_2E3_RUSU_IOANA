package compulsory;

import java.util.List;
import java.util.Random;

public class Robot implements Runnable {
    String name;
    boolean running;
    Exploration explore;
    Random random;
    SharedMemory tokenList;
    List<Token> extractedTokens;

    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running = true;
        this.random = new Random();
        this.tokenList = explore.getMemory();
    }

    public void stop() {
        this.running = false;
    }


    public void run() {
        while (running) {
            int row = random.nextInt(explore.getMap().getRows());
            int column = random.nextInt(explore.getMap().getColumns());
            int numberTokensToExtract = random.nextInt(3);
            extractedTokens = (List<Token>) tokenList.extractTokens(numberTokensToExtract);
            explore.getMap().visit(row, column, this);
            try {
                Thread.sleep(random.nextInt(400) + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
