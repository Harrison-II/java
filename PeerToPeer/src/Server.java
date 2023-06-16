import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void startServer(ServerSocket listener) {
        int port = 9919;
        try {
            listener = new ServerSocket(port);

            while (true) {
                System.out.println("Waiting for connection...");

                Socket socket = listener.accept();
                System.out.println("Connected on port: " + port);
                ServerHandler serverHandler = new ServerHandler(socket);
                new Thread(serverHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {

            } catch (Exception e) {
                System.out.println("Something went wrong! x_x");
            }
        }
    }

}
