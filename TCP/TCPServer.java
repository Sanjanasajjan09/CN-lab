/* Using TCP/IP sockets, write a client – server program to make the 

client send the file name and to make the server send back the contents 

of the requested file if present*/


/*SERVER program*/

import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSock = new ServerSocket(6000);
             Socket sock = serverSock.accept();
             BufferedReader fileRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true)) {

            System.out.println("Server ready, waiting for client request...");
            try (BufferedReader contentRead = new BufferedReader(new FileReader(fileRead.readLine()))) {
                contentRead.lines().forEach(pwrite::println);
            }
        }
    }
}



/*first the server port should be established before it accepts any request from the client*/  