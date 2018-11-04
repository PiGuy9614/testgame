//Nicholas Koeppen & Austin Metz
//Used to enhance router programming skills & make a fun multiplayer game
import java.io.*;
import java.net.*;
import javax.swing.*;
public class TCPClient {
    public static void main() throws Exception {
        String myUsername = JOPI("Enter your username...");
        boolean linkEstablished = false; 
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Gives the ability to read the user's sentence
        String preliminaryIP = JOPI("What is the Server's IP?");
        // InetAddress serverIP = InetAddress.getByName(preliminaryIP); //Gets my IP and stores it        
        // int connectTimes = 0;
        // linkEstablished = serverIP.isReachable(1000); //Checks if I can be connected to other PC        
        // while (!linkEstablished) { //If I'm unavailable, this will explain it
            // if (connectTimes == 3) {
                // preliminaryIP = JOPI("Please retype the Server's IP...");
                // serverIP = InetAddress.getByName(preliminaryIP); //Gets my IP and stores it
            // }
            // linkEstablished = serverIP.isReachable(500); //Checks if I can be connected to other PC
        // }
        Socket clientSocket = new Socket(preliminaryIP, 9614); //Uses IP to connect to my computer's server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        outToServer.writeBytes(myUsername + "\n");
        String name = inFromServer.readLine();
        while (true) {
            String output = JOPI("You're playing Rock, Paper, Scissors with " + name + ". Please enter your move...");
            output.toLowerCase();
            char move = output.charAt(0);
            while (move != 'r' && move != 'p' && move != 's') {
                output = JOPI("Please enter a valid move (Rock, Paper, or Scissors)...");
                output.toLowerCase();
                move = output.charAt(0);
            }
            outToServer.writeBytes(new String("" + move) + "\n");

            JOPM(inFromServer.readLine());
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