import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("Lesson01/ 123.txt");
        String text = "Java is fun";

        try {
            Files.write(filePath, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e){
            System.out.println("Error");
        }
    }
}