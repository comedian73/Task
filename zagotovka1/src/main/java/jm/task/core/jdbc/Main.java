package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl act = new UserDaoHibernateImpl();
//        act.dropUsersTable();
//        act.createUsersTable();
//        act.saveUser("Николай","Фомичев", (byte) 33);
//        act.saveUser("Василий","Семенов", (byte) 15);
//        act.saveUser("Людмила","Тулаева", (byte) 27);
//        act.saveUser("Тамара","Островская", (byte) 54);
        //act.removeUserById(5);
        //System.out.println(act.getAllUsers().toString());
        act.cleanUsersTable();
        System.out.println(act.getAllUsers().toString());
    }
}
