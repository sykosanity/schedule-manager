package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.sql.*;

public class Database {

    public static List<HashMap<String, String>> dbAccounts = new ArrayList<>();

    public static void initDatabase() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schedule_manager_db", "root", "")) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");

            dbAccounts.clear(); // Clear previous data

            while (resultSet.next()) {
                HashMap<String, String> userData = new HashMap<>();
                userData.put("uid", String.valueOf(resultSet.getInt("uid")));
                userData.put("user_name", resultSet.getString("user_name").trim());
                userData.put("user_password", resultSet.getString("user_password").trim());
                userData.put("full_name", resultSet.getString("full_name").trim());
                userData.put("rank", resultSet.getString("rank").trim());
                userData.put("permissions", resultSet.getString("permissions").trim());

                dbAccounts.add(userData); // Store user data in the list
            }
            // ✅ Debugging: Print fetched data
            System.out.println("Database fetched accounts:");
            for (HashMap<String, String> user : dbAccounts) {
                System.out.println(user);
            }

        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static List<HashMap<String, String>> getDatabase() {
        return dbAccounts;
    }
}
