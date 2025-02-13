
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

        Path directoryPath = Paths.get("Lesson01");
        try {

            Files.walkFileTree(directoryPath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                    LocalDate localdate = attributes.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate now = LocalDate.now();
                    if (localdate.isAfter(now.minusDays(7))) {
                        System.out.println(file);
                    }
                    return FileVisitResult.TERMINATE;
                }
            });
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
