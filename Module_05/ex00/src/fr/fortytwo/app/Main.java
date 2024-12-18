package fr.fortytwo.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "admin";
        String password = "pass";

        try {
            // Register the driver (optional for JDBC 4.0+)
            // Class.forName("org.postgresql.Driver");


            // Establish connection
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection established successfully!");

            // Close connection
            connection.close();
        // } catch (ClassNotFoundException e) {
        //     System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
