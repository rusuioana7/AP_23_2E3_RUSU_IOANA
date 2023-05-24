package homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private final int port;
    private boolean isRunning;
    private List<Game> games;
    private Board board;
    private List<Player> players;
    private Game currentGame;


    public Game getCurrentGame() {
        return currentGame;
    }

    public GameServer(int port) {
        this.port = port;
        this.isRunning = false;
        this.games = new ArrayList<>();
        this.board = null;
        this.players = new ArrayList<>();
        this.currentGame = null;  // Initialize current game as null
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            isRunning = true;

            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized Game createGame(int rows, int cols) {
        if (board != null) {
            System.out.println("Game already created.");
            return null;
        }

        board = new Board(rows, cols);
        Game game = new Game();
        games.add(game);
        currentGame = game;

        System.out.println("Game created: " + game.toString());
        return game;

    }

    public synchronized void joinGame(String playerName, char playerSymbol) {
        if (board == null) {
            System.out.println("No game available to join.");
            return;
        }

        if (players.size() >= 2) {
            System.out.println("The game is already full.");
            return;
        }

        Player player = new Player(playerName, playerSymbol);
        players.add(player);

        if (currentGame.getPlayer1() == null) {
            currentGame.setPlayer1(player);
            System.out.println("Player " + playerName + " joined the game. Waiting for another player to join...");
        } else if (currentGame.getPlayer2() == null) {
            currentGame.setPlayer2(player);
            System.out.println("Player " + playerName + " joined the game. Game started!");

            currentGame.start(board.getRows(), board.getCols());

            games.remove(currentGame);
        }
    }


    public synchronized void submitMove(String playerName, int row, int col) {
        if (board == null) {
            System.out.println("No game available to submit moves.");
            return;
        }

        if (players.isEmpty()) {
            System.out.println("No players have joined the game yet.");
            return;
        }

        if (currentGame == null) {
            System.out.println("No game available to submit moves.");
            return;
        }

        if (currentGame.isGameOver()) {
            System.out.println("The game is already over.");
            return;
        }

        Player player = getPlayerByName(playerName);

        if (player == null) {
            System.out.println("Player " + playerName + " is not part of the game.");
            return;
        }

        if (currentGame.getCurrentPlayer() != player) {
            System.out.println("It's not your turn, " + playerName + ".");
            return;
        }

        if (!board.isValidMove(row, col)) {
            System.out.println("Invalid move.");
            return;
        }

        board.makeMove(row, col, player.getSymbol());
        board.display();

        if (board.hasWinner(row, col, player.getSymbol())) {
            System.out.println("Player " + playerName + " wins!");
            currentGame.setGameOver(true);
            return;
        }

        if (board.isFull()) {
            System.out.println("It's a draw!");
            currentGame.setGameOver(true);
            return;
        }


        currentGame.switchTurn();

        Player nextPlayer = currentGame.getCurrentPlayer();
        System.out.println("It's now " + nextPlayer.getName() + "'s turn.");
    }


    public synchronized int getPlayersCount() {
        return players.size();
    }

    private Player getPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int port = 5000;
        GameServer server = new GameServer(port);
        server.start();
    }
}

