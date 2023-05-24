package homework;

public class Player {
    private final String name;
    private final char symbol;
    //private long remainingTime;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;

    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }


}

