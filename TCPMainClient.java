//Nicholas Koeppen
//Used to enhance router programming skills
import java.io.*;
import java.net.*;
import javax.swing.*;
class TCPMainClient {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(9614);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();

            InetAddress client = connectionSocket.getInetAddress(); 
            String clientName = "John Doe";
            if (client.toString().equals("192.168.1.241")) {
                clientName = "Isaiah"; 
            } else if (client.toString().equals("192.168.1.241")) {
                clientName = "Ben"; 
            }  else if (client.toString().equals("192.168.1.241")) {
                clientName = "Ryan"; 
            }

            JOPM(clientName + ": " + clientSentence);

            outToClient.writeBytes(JOPI("How would you like to respond to " + clientName + "?"));
        }
    }

    public static String JOPI(String m) {
        String r = JOptionPane.showInputDialog(null, m);
        return r;
    }

    public static void JOPM(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}