package lesson4;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

public class UserSQLLiteDao implements UserDao, Closeable {


    private static final String USERS_TABLE = "CREATE TABLE IF NOT EXISTS USERS\n" +
            "(\n" +
            "    ID         INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "    LOGIN      TEXT NOT NULL,\n" +
            "    PASSWORD    TEXT NOT NULL,\n" +
            "    NIK_NAME TEXT NOT NULL);" +
            "create unique index USERS_LOGIN_uindex on USERS22 (LOGIN);" +
            "create unique index USERS_NIK_NAME_uindex on USERS22 (NIK_NAME)" +
            ";";


    private final Connection connection;
    private final Statement statement;

    public UserSQLLiteDao() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        connection = DriverManager.getConnection(
                "jdbc:sqlite:C:\\Java\\Java\\Chat\\src\\main\\java\\" +
                        "lesson4\\UserDB");
        statement = connection.createStatement();
        statement.execute(USERS_TABLE);

    }

    @Override
    public boolean userExists(String login) throws SQLException {
        String sql = String.format("SELECT LOGIN FROM USERS WHERE LOGIN = %s", login);
        ResultSet rs = statement.executeQuery(sql);
        return rs.next();
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        String sql = String.format("SELECT * FROM USERS WHERE LOGIN = '%s'", login);
        User user = new User(null, null);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {

            user.setLogin(rs.getString("LOGIN"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setNikName(rs.getString("NIK_NAME"));

        }
        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql;
        if (user.getLogin() != null) {
            sql = String.format("INSERT INTO USERS (LOGIN, PASSWORD) " +
                            "VALUES ('%s', '%s')",
                    user.getLogin(),
                    user.getPassword());
            statement.execute(sql);
        }

    }

    @Override
    public void addUser(User user, String nikName) throws SQLException {
        String sql;
        user.setNikName(nikName);
        if (user.getLogin() != null) {
            sql = String.format("UPDATE USERS SET LOGIN = '%s', PASSWORD = '%s', " +
                            ", NIK_NAME = %s WHERE LOGIN = %s",
                    user.getLogin(),
                    user.getPassword(),
                    user.getNikName(),
                    user.getLogin());

            statement.execute(sql);

        }
    }


    @Override
    public void close() throws IOException {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}






