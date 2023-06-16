import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        ServerSocket listener = null;
        Socket socket = null;

        Server server = new Server();
        Client client = new Client();

        server.startServer(listener);
        client.startClient(socket);
    }
}