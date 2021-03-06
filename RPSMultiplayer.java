//Nicholas Koeppen & Austin Metz
//Used to thoroughly enjoy a P2P Rock, Paper, Scissors game
import javax.swing.*;
public class RPSMultiplayer {
    public static void main(String[] args) throws Exception {
        Icon icon = new ImageIcon("MonaSeaver.jpg", "Mona Seaver");
        JOptionPane.showMessageDialog(null,
            "It's Traditional Rock, Paper, Scissors. You live a tragic life if you've somehow avoided this game until now...",
            "Multiplayer Rock, Paper, Scissors",
            JOptionPane.INFORMATION_MESSAGE, icon);
        String[] options = {"Host a Game", "Join a Game"};
        int r = JOptionPane.showOptionDialog(null, "Would you like to host or join the game?", "Whaddya want to do?",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        if (r == 0) { //Opens Main Client (Server) Class
            TCPMainClient.main();
        } else if (r == 1) { //Opens Client Class
            TCPClient.main();
        }
    }
}