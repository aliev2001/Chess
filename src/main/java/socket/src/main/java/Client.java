import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        final short PORT = 4444;
        Socket socket = null;

        try{
            socket = new Socket("localhost", PORT);
        } catch (IOException e){
            System.err.println("connection error");
            e.printStackTrace();
        }
    }
}
