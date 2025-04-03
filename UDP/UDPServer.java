/*Write a program on datagram socket for client/server to display the 
messages on client side, typed at the server side.*/

import java.net.*;
//import java.io.*;
public class UDPServer {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket serverSocket = new DatagramSocket(9666)) {
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData()).trim();

                byte[] sendData = sentence.toUpperCase().getBytes();
                serverSocket.send(new DatagramPacket(sendData, sendData.length,receivePacket.getAddress(), receivePacket.getPort()));
            }
        }
    }
}


/*first run the server program and then the client program in another terminal*/