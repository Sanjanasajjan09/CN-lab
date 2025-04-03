/*UDP cleint program*/
import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket socket = new DatagramSocket();
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter lowercase text: ");
            byte[] sendData = userInput.readLine().getBytes();
            socket.send(new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 9666));

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            System.out.println("FROM SERVER: " + new String(receivePacket.getData()).trim());
        }
    }
}

     
/*output;-
  first run the server program in one terminal in another terminal run the client program
Server side
javac UDPServer.java
java UDPServer
Server is Ready for the client
RECEIVED: abcdef

Client Side
javac UDPClient.java
java UDPClient
Enter the string in lowercase so that you receive the message in Uppercase from the server
abcdef
FROM SERVER: ABCDEF
*/