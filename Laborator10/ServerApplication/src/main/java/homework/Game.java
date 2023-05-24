package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean isGameOver;
    private Player currentPlayer;

    public Game() {
        this.player1 = null;
        this.player2 = null;
        this.isGameOver = false;
        this.currentPlayer = null;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void start(int rows, int cols) {
        currentPlayer = player1;
        Board board = new Board(rows, cols);
        board.display();

    }

    public void switchTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
