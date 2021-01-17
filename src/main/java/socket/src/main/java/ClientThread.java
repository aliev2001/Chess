import java.net.Socket;

public class ClientThread extends Server implements Runnable {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

    }
}
