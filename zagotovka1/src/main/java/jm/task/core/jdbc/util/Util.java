package jm.task.core.jdbc.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.*;
import java.util.Properties;

public class Util {
    public static Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "user1";
        String pass = "pass123";
        return DriverManager.getConnection(url, user, pass);
    }
    private static Properties hibernateProperties(){
        final Properties properties = new Properties();
            properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/mydb");
            properties.put("hibernate.connection.username", "user1");
            properties.put("hibernate.connection.password", "pass123");
            properties.put("connection.pool_size", "1");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            properties.put("current_session_context_class", "thread");
            properties.put("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
            properties.put("show_sql", "true");
            properties.put("hbm2ddl.auto", "update");
        return properties;
    }

    public static SessionFactory hibConnect() {
        try {
            return new Configuration().setProperties(hibernateProperties()).buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
