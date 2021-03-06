package lesson4;

public class User {

    private int id;
    private String login;
    private String password;
    private String nikName;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String nikName) {
        this.login = login;
        this.password = password;
        this.nikName = nikName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}
