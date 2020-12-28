package lesson4;

import java.sql.SQLException;

public interface AuthService {

    void addUser(boolean accept, String name, String pass, String nikName) throws SQLException;

    boolean auth(String name, String pass) throws SQLException;

}
