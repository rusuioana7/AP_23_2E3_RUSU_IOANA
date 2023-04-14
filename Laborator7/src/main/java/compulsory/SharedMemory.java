package compulsory;

import java.util.*;

public class SharedMemory {
    List<Token> tokens;

    public SharedMemory(int n) {
        this.tokens = new ArrayList<>();

        for (int i = 1; i <= n * n * n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }

}
