package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GameServer gameServer;

    public ClientThread(Socket clientSocket, GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
    }

    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String command;
            while ((command = in.readLine()) != null) {
                parseCommand(command);

                Game currentGame = gameServer.getCurrentGame();
                if (currentGame != null && currentGame.isGameOver()) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0].toLowerCase();

        if (action.equals("create") && parts.length == 4 && parts[1].equals("game")) {
            int rows = Integer.parseInt(parts[2]);
            int cols = Integer.parseInt(parts[3]);
            gameServer.createGame(rows, cols);

            out.println("Game created.");
        } else if (action.equals("join") && parts.length == 4 && parts[1].equals("game")) {
            String playerName = parts[2];
            char playerSymbol = parts[3].charAt(0);
            gameServer.joinGame(playerName, playerSymbol);

            if (gameServer.getPlayersCount() < 2) {
                out.println("Player " + playerName + " joined the game. Waiting for another player to join...");
            } else {
                out.println("Player " + playerName + " joined the game. Game started!");
            }
        } else if (action.equals("submit") && parts.length == 5 && parts[1].equals("move")) {
            String playerName = parts[2];
            int row = Integer.parseInt(parts[3]);
            int col = Integer.parseInt(parts[4]);
            gameServer.submitMove(playerName, row, col);

            Player currentPlayer = gameServer.getCurrentGame().getCurrentPlayer();
            Game currentGame = gameServer.getCurrentGame();

            if (currentGame.isGameOver()) {
                out.println("Game Over. " + currentPlayer.getName() + " wins!");
                return;
            }

            out.println("It's now " + currentGame.getCurrentPlayer().getName() + "'s turn.");
        } else {
            out.println("Invalid command.");
        }
    }
}

