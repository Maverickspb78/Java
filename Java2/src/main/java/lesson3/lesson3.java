package lesson3;

import java.util.*;


public class lesson3 {
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<>();
        arr.add("робот");
        arr.add("собака");
        arr.add("кот");
        arr.add("лошадь");
        arr.add("робот");
        arr.add("кот");
        arr.add("италия");
        arr.add("кот");
        arr.add("два");
        arr.add("цик");
        arr.add("три");
        arr.add("два");

        TreeMap<String, Integer> map = new TreeMap<>();


        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        System.out.println(map);

        PhoneBook book = new PhoneBook();
        book.addPhoneNumber("Mikhail", "+7921921996633");
        book.addPhoneNumber("Mikhail", "+7911911774411");
        book.addPhoneNumber("Nikolay", "8956854212");
        book.info();
    }

}
