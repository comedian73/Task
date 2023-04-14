package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl udj = new UserDaoJDBCImpl();
    public void createUsersTable() {
       udj.createUsersTable();
    }

    public void dropUsersTable() {
        udj.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udj.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        udj.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return udj.getAllUsers();
    }

    public void cleanUsersTable() {
        udj.cleanUsersTable();
    }
}
