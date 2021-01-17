import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        final short PORT = 4444;
        ServerSocket serSocket = null;
        ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
        try {
            serSocket = new ServerSocket(PORT);
            while(true) {
                try {
                    serSocket.accept();
                    ClientThread client = new ClientThread(serSocket.accept());
                    Thread thread = new Thread(client);
                    thread.start();
                    clients.add(client);
                }catch (IOException e){
                    System.out.println("error");
                }
            }
        } catch (IOException e) {
            System.err.println("connection error");
            System.exit(1);
        }
    }
}

