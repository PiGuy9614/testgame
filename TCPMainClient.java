//Nicholas Koeppen
//Used to enhance router programming skills
import java.io.*;
import java.net.*;
import javax.swing.*;
class TCPMainClient {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        ServerSocket welcomeSocket = new ServerSocket(9614);
        while (true) {
            Socket connection = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());

            InetAddress client = connection.getInetAddress(); 
            String clientName = inFromClient.readLine();

            outToClient.writeBytes(JOPI("Please tell " + clientName + " your username?"));
            
            String mainClientmove = JOPI("You are playing with " + clientName + ". What is your move?");
            String clientMove = inFromClient.readLine();
            
            
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