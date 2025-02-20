import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop applications are not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File("downloadGIT.html");
        try {
           // desktop.open(file);
            URI uri = new URI("mailto:mihaela_trencheska@yahoo.com/subject=testSubject&body=bodyContent");
            desktop.mail();
        }catch (IOException e){
            System.out.println("Error happened while opening file");
        }catch (URISyntaxException e){
            System.out.println("Error while sending email");
        }
    }
}