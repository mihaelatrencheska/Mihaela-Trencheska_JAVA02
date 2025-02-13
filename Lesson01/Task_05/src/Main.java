import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("Lesson01/binaryFile.bin");
        byte[] array = {1, 2, 3, 4, 5};
        try {
            Files.write(filePath, array);
            System.out.println("the content was successfuly added to the file");

            byte[] readData= Files.readAllBytes(filePath);
            for(byte b : readData){
                System.out.println(b + " ");
            }
        } catch (IOException e) {

        }
    }
}
