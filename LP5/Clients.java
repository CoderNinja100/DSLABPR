






import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clients {
    private String serverAddress;
    private int serverPort;
    private BufferedReader reader;
    private PrintWriter writer;
    public Clients(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }
    public void connect() {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            // Start sending and receiving messages
            startMessageExchange();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startMessageExchange() {
        new Thread(() -> {
            try {
                while (true) {
                    // Read message from server
                    String message = reader.readLine();
                    if (message != null) {
                        System.out.println("Message received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                // Read input from console
                String input = consoleReader.readLine();
                if (input != null) {
                    // Send message to server
                    writer.println(input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Client client = new Client("localhost", 8080);
        client.connect();
    } }
