package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name"; // Cambia el nombre de la base de datos
    private static final String USER = "i7313497_c9gm1";
    private static final String PASSWORD = "W.s7k1wlloywMlwn0Y851";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
