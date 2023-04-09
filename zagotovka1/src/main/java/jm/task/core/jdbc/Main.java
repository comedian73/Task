package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl act = new UserDaoJDBCImpl();
        act.createUsersTable();
        act.saveUser("Николай","Фомичев", (byte) 33);
        act.saveUser("Василий","Семенов", (byte) 15);
        act.saveUser("Людмила","Тулаева", (byte) 27);
        act.saveUser("Тамара","Островская", (byte) 54);
        act.getAllUsers();
        System.out.println(act.getAllUsers().toString());
        act.cleanUsersTable();
        act.dropUsersTable();
    }
}
