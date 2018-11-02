//Nicholas Koeppen
//Used to enhance router programming skills
import java.io.*;
import java.net.*;
import javax.swing.*;
class TCPClient {
    public static void main(String argv[]) throws Exception {
        boolean linkEstablished = false; 
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Gives the ability to read the user's sentence
        InetAddress serverIP = InetAddress.getByName("PiGuyPC"); //Gets my IP and stores it
        linkEstablished = serverIP.isReachable(500); //Checks if I can be connected to other PC
        while (!linkEstablished) { //If I'm unavailable, this will explain it
            JOPM("Sorry but there is an error. We cannot currently connect to Nick's PC. \nPlease try again later...");
        }
        Socket clientSocket = new Socket(serverIP, 9614); //Uses IP to connect to my computer's server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String sentence = JOPI("What would you like to ask Nick?");
        outToServer.writeBytes(sentence + '\n');
        String modifiedSentence = inFromServer.readLine();
        JOPM("Nick: " + modifiedSentence);
    }
    
    public static String JOPI(String m) {
        String r = JOptionPane.showInputDialog(null, m);
        return r;
    }
    
    public static void JOPM(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}