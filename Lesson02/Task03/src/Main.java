import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URI uri = URI.create("https://uacs.edu.mk/home/home/");
            URL url = uri.toURL();

            System.out.println(url.getAuthority());
            System.out.println(url.getDefaultPort());
            System.out.println(url.getProtocol());
            System.out.println(url.getPort());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
            System.out.println(url.getPath());
            System.out.println(url);


        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}