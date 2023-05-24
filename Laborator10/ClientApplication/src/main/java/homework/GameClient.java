package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private final String serverAddress;
    private final int serverPort;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                Scanner scanner = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String command;
            String response;
            while (true) {
                command = scanner.nextLine();
                out.println(command);
                if (command.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    response = in.readLine();
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 5000;
        GameClient client = new GameClient(serverAddress, serverPort);
        client.start();
    }
}
