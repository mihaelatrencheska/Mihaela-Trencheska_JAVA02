import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BoardClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server");
            String userInput;

            while (true) {
                System.out.print("Enter command: ");
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("bye")) {
                    out.println("bye");
                    System.out.println("Disconnected from server");
                    break;
                }

                out.println(userInput);
                String response = in.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            System.out.println("Error: Server unavailable");
        }
    }
}