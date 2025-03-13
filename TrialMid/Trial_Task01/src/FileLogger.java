import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileLogger {
    private static final String FILE_NAME = "log.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim();

            if (command.startsWith("log ")) {
                String message = command.substring(4);
                logMessage(message);
            } else if (command.equals("read")) {
                readLog();
            } else if (command.equals("clear")) {
                clearLog();
            } else if (command.equals("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Unknown command. Please use log, read, clear, or exit.");
            }
        }

        scanner.close();
    }

    private static void logMessage(String message) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_NAME, true);
            fileWriter.write(message + System.lineSeparator());
            System.out.println("Message logged");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error: Cannot close file writer");
                }
            }
        }
    }

    private static void readLog() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Error: File not found");
            return;
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("Content:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error: Cannot close file reader");
                }
            }
        }
    }

    private static void clearLog() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File cleared");
            } else {
                System.out.println("Error: Cannot delete file");
            }
        } else {
            System.out.println("Error: File not found");
        }
    }
}