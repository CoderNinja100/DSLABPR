
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MutualServer {
 private ServerSocket serverSocket;
 private Socket client1Socket;
 private Socket client2Socket;
 private BufferedReader client1Reader;
 private PrintWriter client1Writer;
 private BufferedReader client2Reader;
 private PrintWriter client2Writer;
 public MutualServer(int port) {
 try {
 serverSocket = new ServerSocket(port);
 System.out.println("Server started and listening on port " + port);
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
  
  public void acceptConnections() {
 try {
   // Accept client 1 connection
 client1Socket = serverSocket.accept();
 System.out.println("Client 1 connected: " + client1Socket.getInetAddress().getHostAddress());
 client1Reader = new BufferedReader(new InputStreamReader(client1Socket.getInputStream()));
 client1Writer = new PrintWriter(client1Socket.getOutputStream(), true);
   
   // Accept client 2 connection
 client2Socket = serverSocket.accept();
 System.out.println("Client 2 connected: " + client2Socket.getInetAddress().getHostAddress());
 client2Reader = new BufferedReader(new InputStreamReader(client2Socket.getInputStream()));
 client2Writer = new PrintWriter(client2Socket.getOutputStream(), true);
   
   // Start message exchange
 startMessageExchange();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
  
  public void startMessageExchange() {
 new Thread(() -> {
   
   try {
 while (true) {
 // Read message from client 1
 String messageFromClient1 = client1Reader.readLine();
 if (messageFromClient1 != null) {
 System.out.println("Message received from Client 1: " + messageFromClient1);
 // Forward message to client 2
 client2Writer.println(messageFromClient1);
 }
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }).start()
   
 try {
 while (true) {
 // Read message from client 2
 String messageFromClient2 = client2Reader.readLine();
 if (messageFromClient2 != null) {
 System.out.println("Message received from Client 2: " + messageFromClient2);
 // Forward message to client 1
 client1Writer.println(messageFromClient2);
 }
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 public static void main(String[] args) {
 MutualServer server = new MutualServer(8080);
 server.acceptConnections();
 } }
