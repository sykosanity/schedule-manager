package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.sql.*;

public class Database {

    public static List<HashMap<String, String>> dbAccounts = new ArrayList<>();
    public static List<HashMap<String, String>> dbStaff = new ArrayList<>();

    public static void initDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_manager_db", "root", "")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement statement = connection.createStatement();
            ResultSet accountsRetVal = statement.executeQuery("SELECT * FROM accounts");

            dbAccounts.clear(); // Clear previous data

            while (accountsRetVal.next()) {
                HashMap<String, String> userData = new HashMap<>();

                userData.put("uid", String.valueOf(accountsRetVal.getInt("uid")));
                userData.put("user_name", accountsRetVal.getString("user_name").trim());
                userData.put("user_password", accountsRetVal.getString("user_password").trim());
                userData.put("full_name", accountsRetVal.getString("full_name").trim());
                userData.put("rank", accountsRetVal.getString("rank").trim());
                userData.put("permissions", accountsRetVal.getString("permissions").trim());

                dbAccounts.add(userData);
            }

            //            for (HashMap<String, String> user : dbAccounts) {
//                System.out.println(user);
//            }
            System.out.println("Database fetched accounts successfully!");

        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static List<HashMap<String, String>> getAccounts() {
        return dbAccounts;
    }

    public static List<HashMap<String, String>> getStaff() {
        return dbStaff;
    }
}
