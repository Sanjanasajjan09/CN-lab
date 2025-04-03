/*Client program*/
import java.net.*;
import java.io.*;
public class TCPClient {
    public static void main(String[] args) throws Exception {
        try (Socket sock = new Socket("127.0.0.1", 6000);
             BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true);
             BufferedReader socketRead = new BufferedReader(new InputStreamReader(sock.getInputStream()))) {

            System.out.print("Enter the filename: ");
            pwrite.println(keyRead.readLine());

            String str ;
            while ((str = socketRead.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}


       
/*First run the server program then in new terminal window run the client program and input the 
file name the server will return the file content if it exists

output:-
SERVER PROGRAM

javac TCPS.java
java TCPS
Server ready for connection
Connection Is successful and waiting for the client request

CLIENT program
in new terminal window
javac TCPC.java
 java TCPC
Enter the filename
text.txt
This the file client requested from the server....
*/
  