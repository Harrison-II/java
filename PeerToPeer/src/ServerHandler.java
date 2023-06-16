import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerHandler implements Runnable{

    Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String msg = (String) objectInputStream.readObject();
            System.out.println("Peer sent: " + msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception ex) {
                System.out.println("Failed to close socket connection");
            }
        }
    }
}
