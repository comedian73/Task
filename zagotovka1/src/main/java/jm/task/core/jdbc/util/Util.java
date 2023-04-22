package jm.task.core.jdbc.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class Util {
    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/mydb";
        String user = "user1";
        String pass = "pass123";
        return DriverManager.getConnection(url, user, pass);
    }
    private static Properties hibernateProperties(){
        final Properties properties = new Properties();

        properties.put("hibernate.hbm2ddl.auto", "update" );
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver" );
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect" );
        properties.put("hibernate.connection.datasource", dataSource());

        return properties;
    }

    private static DataSource dataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("mydb");
        dataSource.setUser("user1");
        dataSource.setPassword("pass123");
        return dataSource;
    }

    public SessionFactory hibConnect() {
        Configuration cfg = new Configuration().setProperties(hibernateProperties());
        return cfg.buildSessionFactory();
    }
}
