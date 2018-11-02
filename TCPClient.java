//Nicholas Koeppen
//Used to enhance router programming skills
import java.io.*;
import java.net.*;
import javax.swing.*;
class TCPClient {
    public static void main(String argv[]) throws Exception {
        boolean linkEstablished = false; 
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Gives the ability to read the user's sentence
        String ip = JOPI("What is the Server's IP Address?"); //Takes Server IP from User input
        InetAddress serverIP = InetAddress.getByName(ip); //Gets my IP and stores it
        linkEstablished = serverIP.isReachable(500); //Checks if I can be connected to other PC
        while (!linkEstablished) { //If I'm unavailable, this will explain it
            ip = JOPI("Sorry but there is an error. We cannot currently connect to this PC. Please retype the server IP..."); //Takes Server IP from User input
            serverIP = InetAddress.getByName(ip); //Gets my IP and stores it
            linkEstablished = serverIP.isReachable(500); //Checks if I can be connected to other PC
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