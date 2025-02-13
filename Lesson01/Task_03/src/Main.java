import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path directoryPath = Paths.get("Lesson01/Task_01/src");
        try {
            Files.newDirectoryStream(directoryPath, "*" + ".java").forEach(file -> System.out.println(file));

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();

        }
    }
}
