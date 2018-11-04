//Nicholas Koeppen & Austin Metz
//Used to enhance router programming skills & make a fun multiplayer game
import java.io.*;
import java.net.*;
import javax.swing.*;
public class TCPMainClient {
    public static void main() throws Exception {
        String username = JOPI("Enter your username...");
        ServerSocket welcomeSocket = new ServerSocket(9614);
        InetAddress localhost = InetAddress.getLocalHost();
        //JOPM("Your IP Address is " + localhost.getHostAddress() + "\nPlease wait a second as your opponent is connecting...");
        Socket connection = welcomeSocket.accept();
        
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
        
        InetAddress client = connection.getInetAddress(); 
        String clientName = inFromClient.readLine();
        int ui = -1, oi = -1;
        char uwon; //U = The main client and O = The opposing client
        String output;

        outToClient.writeBytes(username + "\n");
        exit:
        while(true) {
            String mcm = JOPI("You are playing with " + clientName + ". What is your move?");
            switch(mcm.toLowerCase().charAt(0)) {
                case 'r':
                ui = 0;
                break;
                case 'p':
                ui = 1;
                break;
                case 's':
                ui = 2;
                break;
                case 'e':
                break exit;
                default:
                mcm = JOPI("Invalid entry, enter again!");
            }
            String cm = inFromClient.readLine();
            switch(cm.charAt(0)) {
                case 'r':
                oi = 0;
                break;
                case 'p':
                oi = 1;
                break;
                case 's':
                oi = 2;
                break;
            }
            uwon = ((ui > oi && !(ui == 2 && oi == 0)) || (ui == 0 && oi == 2)) ? 'w' : (ui == oi) ? 't' : 'l';
            output = (uwon == 'w') ? "You lost!" : (uwon == 't') ? "You tied!" : "You won!";
            outToClient.writeBytes(output + "\n");
            output = (uwon == 'w') ? "You won!" : (uwon == 't') ? "You tied!" : "You lost!";
            JOPM(output);
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