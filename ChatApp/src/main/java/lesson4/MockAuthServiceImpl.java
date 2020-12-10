package lesson4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MockAuthServiceImpl implements AuthService {

    private static MockAuthServiceImpl instance;
    private final HashMap<String, String> userDao;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean accept = false;


    private MockAuthServiceImpl() {
        userDao = new HashMap<>();

        try {
            reader = new BufferedReader(
                    new FileReader("C:\\Java\\Java\\ChatApp\\src\\main\\resources\\lesson4\\registr.txt"));
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                userDao.put(tmp, reader.readLine());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static MockAuthServiceImpl getInstance() {
        if (instance == null) {
            instance = new MockAuthServiceImpl();
        }
        return instance;
    }

    public HashMap<String, String> getUserDao() {
        return userDao;
    }

    @Override
    public void addUser(boolean accept, String name, String pass) {
        setAccept(false);
        boolean newUser = true;

        for (Map.Entry<String, String> entry : userDao.entrySet()) {
            if ((entry.getKey().equals(name))) {
                newUser = false;
            }
        }

        if (newUser) {
            userDao.put(name, pass);
            System.out.println(userDao);
            try {
                writer = new BufferedWriter(
                        new FileWriter("C:\\Java\\Java\\ChatApp\\src\\main\\resources\\lesson4\\registr.txt", true));
                writer.write("\n");
                writer.write(name + "\n");
                writer.write(pass);
                writer.close();
                setAccept(true);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean auth(String name, String pass) {

        for (Map.Entry<String, String> entry : userDao.entrySet()) {
            if (entry.getKey().equals(name) && entry.getValue().equals(pass)) {

                return true;


            }
        }
        return false;

    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
