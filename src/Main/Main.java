package Main;

import Components.Login;
import Database.Database;
import Main.DiscordLog;

import mdlaf.MaterialLookAndFeel;
import javax.swing.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        String pcName = InetAddress.getLocalHost().getHostName();  // Get actual PC name
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        return "[" + timestamp + "] " + pcName + ": " + message;
        
        DiscordLog.log("Started at [" + timestamp + "] from " + pcName + " ");

        Database.initDatabase();

        // Print all user data
        for (HashMap<String, String> db : Database.getAccounts()) {
            System.out.println(db);
            System.out.println(db.get("user_name"));
        }
        
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true); // Replace with your JFrame class
        });

    }

}
