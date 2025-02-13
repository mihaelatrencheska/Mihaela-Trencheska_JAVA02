import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        long timeStamp = System.currentTimeMillis();
        String filePathString = "Lesson01/Uniquefile" + timeStamp + ".txt";
        File file = new File(filePathString);

        if ( file.exists()){
            System.out.println("This file already exists");
        }else{
            Path path = Paths.get(filePathString);
            try{
                Files.createFile(path);
                System.out.println("The file is successfully generated");

            }catch(IOException e){
                System.out.println("Error occured");
            }
        }

    }
}