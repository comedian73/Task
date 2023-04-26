package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import java.sql.*;
import java.util.Properties;

public class Util {
    private static final SessionFactory sessionFactory = hibConnect();
    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "user1";
        String pass = "pass123";
        return DriverManager.getConnection(url, user, pass);
    }
    private static Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mydb");
        properties.put("hibernate.connection.username", "user1");
        properties.put("hibernate.connection.password", "pass123");
        properties.put("connection.pool_size", "1");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put("current_session_context_class", "thread");
//        properties.put("hibernate.connection.provider_class", "ConnectionProvider");
//        properties.put("hibernate.connection.handling_mode", "String");
//            properties.put("hbm2ddl.auto", "update");
        return properties;
    }

    public static SessionFactory hibConnect() {
        return new Configuration()
                .addClass(jm.task.core.jdbc.util.Mapp.class)
                .setProperties(hibernateProperties())
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
