package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Token> tokens;
    private boolean visited;

    public Cell() {
        tokens = new ArrayList<>();
        visited = false;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
