import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Scanner scanner = new Scanner(System.in);

    public void startClient(Socket socket) {
        try {
            socket = new Socket("192.168.100.87", 9919);

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.flush();

            String message = scanner.nextLine();

            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception ex) {
                System.out.println("Something went wrong! x_x");
            }
        }
    }
}
