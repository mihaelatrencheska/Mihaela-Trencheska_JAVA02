import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URI uri = URI.create("https://github.com");
            URL url = uri.toURL();


            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("downloadFile.html"));

            String readLine;
            while ((readLine = bufferedReader.readLine()) != null){
                bufferedWriter.write(readLine);
                bufferedWriter.newLine();
            }
            System.out.println("Download finished successfully");
            bufferedWriter.close();
            bufferedReader.close();

        }catch (MalformedURLException e){
            System.out.println("HERE");
        }
         catch(IOException e){
             System.out.println("HERE1");
         }

        }
    }
