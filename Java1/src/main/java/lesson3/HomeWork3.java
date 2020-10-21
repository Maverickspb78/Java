package lesson3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
//        guessTheWord();
//        guessTheNumber();
    }

    public static int randomNumber() {
        int hiddenNumber = (int) (Math.random() * 10);
        return hiddenNumber;
    }

    public static void guessTheNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Загаданно число от 0 до 9. У вас есть 3 попытки угадать это число");
        int count = 0;
        int hiddenNumber;
        while (true) {
            hiddenNumber = randomNumber();
            while (count < 4) {
                if (count < 3) {
                    System.out.println("Введите число:");
                    int playerNumber = in.nextInt();
                    if (hiddenNumber == playerNumber) {
                        System.out.println("Вы угадали число");
                        break;

                    } else if (hiddenNumber > playerNumber) System.out.println("Загаданное число больше");
                    else System.out.println("Загаданное число меньше");
                    count++;
                } else {
                    System.out.println("Вы проиграли");
                    break;
                }

            }
            System.out.println("Нажмите 1 что бы повторить или 0 что бы выйти");
            int exit = in.nextInt();
            if (exit == 0) break;
            else count = 0;

        }
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Загадано слово, попробуйте угадать");
        int n;

        Scanner in = new Scanner(System.in);
        String word = words[(int)(Math.random()*26)];

        while (true) {
            System.out.println("Введите слово");
            String playerWord = in.nextLine();
            StringBuilder result = new StringBuilder();
            n = Math.min(word.length(), playerWord.length());
            for (int i = 0; i < n; i++) {
                if (word.charAt(i) == playerWord.charAt(i)) result.append(word.charAt(i));
                else result.append("#");
            }
            if (word.contains(result.toString())) {
                System.out.println("Вы угадали слово - " + result + " Молодец!");
                break;
            } else {
                result.append("###############");
                System.out.println("Не угадали, попробуйте еще!");
                System.out.println(result);
            }
        }
    }
}
