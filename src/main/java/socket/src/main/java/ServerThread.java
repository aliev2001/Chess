import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;

    }

    @Override
    public void run(){


    }

}
