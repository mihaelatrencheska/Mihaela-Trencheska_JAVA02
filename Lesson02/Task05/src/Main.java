import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://github.com");
            InputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("downloadGIT.html");
            byte[] bufferData = new byte[1024];
            int byteRead;

            while ((byteRead= inputStream.read(bufferData, 0,1024))!= -1){
                fileOutputStream.write(bufferData, 0,byteRead);
            }
            System.out.println("Finished downloading");


        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}