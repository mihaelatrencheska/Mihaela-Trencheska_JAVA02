import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("Localhost", 8080);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        printWriter.println("Hello client");
        System.out.println(bufferedReader.readLine());


        socket.close();
    }
}
