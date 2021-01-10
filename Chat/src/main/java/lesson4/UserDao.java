package lesson4;

import java.sql.SQLException;

public interface UserDao {

    boolean userExists(String login) throws SQLException;

    User getUserByLogin(String login) throws SQLException;

    void addUser(User user) throws SQLException;

    void addUser(User user, String nikName) throws SQLException;


}
