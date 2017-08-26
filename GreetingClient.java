// File Name GreetingClient.java
import java.net.*;
import java.io.*;

public class GreetingClient {

   public static void main(String [] args) {
      String serverName = args[0];  // ip address
      int port = Integer.parseInt(args[1]);  // port
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);  // connecting to server

         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);

         out.writeUTF("สวัสดี Hello from " + client.getLocalSocketAddress());
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);

         System.out.println("Server says " + in.readUTF());
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}
