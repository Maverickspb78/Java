package lesson3;

import java.util.*;


public class PhoneBook {

        Map<String, ArrayList<String>> phoneBook = new TreeMap<>();

    public void addPhoneNumber(String name, String phoneNumber){
        ArrayList<String> phonelist = phoneBook.get(name);
        if (phonelist == null) phonelist = new ArrayList<>();
        phonelist.add(phoneNumber);
        phoneBook.put(name, phonelist);

    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }

    public void info() {
        System.out.println(phoneBook);
    }
}
