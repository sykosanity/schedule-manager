package Database;

import java.sql.*;

public class Database {

    public static void main(String arg[]) {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/schedule_manager_db",
                "root", 
                ""
            );

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
            
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from accounts");
            
            int uid;
            String userName;
            String userPassword;
            String fullName;
            String rank;
            String permissions;
            
            while (resultSet.next()) {
                uid = resultSet.getInt("uid");
                userName = resultSet.getString("user_name").trim();
                userPassword = resultSet.getString("user_password").trim();
                fullName = resultSet.getString("full_name").trim();
                rank = resultSet.getString("rank").trim();
                permissions = resultSet.getString("permissions").trim();
                System.out.println(
                        "Unique Id: " + uid
                        + " | User Name: " + userName
                        + " | User Password: " + userPassword
                        + " | Full Name: " + fullName
                        + " | User Rank: " + rank
                        + " | User Permission: " + permissions
                        
                );
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    } // function ends

}
