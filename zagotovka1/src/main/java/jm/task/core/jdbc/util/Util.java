package jm.task.core.jdbc.util;
import java.sql.*;
public class Util {
    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "user1";
        String pass = "pass123";
        return DriverManager.getConnection(url, user, pass);
    }

}
