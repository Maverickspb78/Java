package lesson4;

public interface AuthService {

    void addUser(boolean accept, String name, String pass);

    boolean auth(String name, String pass);

}
