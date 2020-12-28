package lesson4;


import java.sql.SQLException;


public class MockAuthServiceImpl implements AuthService {

    private static MockAuthServiceImpl instance;

    private boolean accept = false;
    private final UserSQLLiteDao dao = new UserSQLLiteDao();

    private String nikName;

    private MockAuthServiceImpl() throws SQLException, ClassNotFoundException {

    }

    public static MockAuthServiceImpl getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new MockAuthServiceImpl();
        }
        return instance;
    }

    @Override
    public void addUser(boolean accept, String name, String pass, String nikName) throws SQLException {
        setAccept(false);

        boolean newUser = dao.getUserByLogin(name).getLogin() == null;

        if (newUser) {
            User user = new User(name, pass);
            user.setLogin(name);
            user.setPassword(pass);
            user.setNikName(nikName);
            dao.addUser(user);
            setAccept(true);
        }

    }

    @Override
    public boolean auth(String name, String pass) throws SQLException {
        nikName = name;
        User user = dao.getUserByLogin(name);
        return user.getPassword().contains(pass);

    }

    public User getAuthUser() throws SQLException {
        User user = dao.getUserByLogin(nikName);
        return user;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getNikName() {
        return nikName;
    }

    public UserSQLLiteDao getDao() {
        return dao;
    }
}
