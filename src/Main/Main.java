package Main;

import Components.Login;
import Database.Database;
import mdlaf.MaterialLookAndFeel;
import javax.swing.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        
        Database.initDatabase();

        // Print all user data
        for (HashMap<String, String> db : Database.getDatabase()) {
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
