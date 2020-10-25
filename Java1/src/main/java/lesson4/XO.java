package lesson4;

import java.util.Scanner;

public class XO {
    public static char[][] MAP;
    private static boolean isInGame;
    private static int SIZE;
    private static final char USER = 'X';
    private static final char PC = 'O';
    private static final char DEFAULT = '_';

    static void fillMap(int size) {
        isInGame = true;
        MAP = new char[size][size];
        SIZE = size;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    static boolean move(int x, int y, char player) {
        try {
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = player;
                return true;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static void moveAI() {
        String winingPlayer = "XX";
        String winingPC = "OO";
        String diag1 = "";
        String diag2 = "";
        String vertical = "";
        String horizontal = "";

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                horizontal += MAP[i][j];
                vertical += MAP[j][i];
            }
            if (diag(horizontal)) {
                for (int z = 0; z < SIZE; z++) {
                    if (horizontal.charAt(z) == DEFAULT) {
                        MAP[i][z] = PC;
                        return;
                    }
                }
            }
            if (diag(vertical)) {
                for (int z = 0; z < SIZE; z++) {
                    if (vertical.charAt(z) == DEFAULT) {
                        MAP[z][i] = PC;
                        return;
                    }
                }
            }
            vertical = "";
            horizontal = "";
        }

        for (int i = 0; i < SIZE; i++) {
            diag1 += (MAP[i][i]);
            diag2 += (MAP[i][(SIZE - 1) - i]);
        }

        if (diag(diag1)) {
            for (int i = 0; i < SIZE; i++) {
                if (diag1.charAt(i) == DEFAULT) {
                    if (MAP[i][i] == DEFAULT) {
                        MAP[i][i] = PC;
                        return;
                    }
                }
            }
        }
        if (diag(diag2)) {
            for (int i = 0; i < SIZE; i++) {
                if (diag2.charAt(i) == DEFAULT) {
                    if (MAP[i][(SIZE - 1) - i] == DEFAULT) {
                        MAP[i][(SIZE - 1) - i] = PC;
                        return;
                    }
                }
            }
        } else {
            int x = (int) (Math.random() * SIZE), y = (int) (Math.random() * SIZE);
            while (MAP[x][y] == PC || MAP[x][y] == USER) {
                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);
            }
            MAP[x][y] = PC;
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean diag(String diag) {
        char[] array = diag.toCharArray();
        int countPC = 0;
        int countUS = 0;
        for (int i = 0; i < SIZE; i++) {
            if (array[i] == PC) countPC++;
            if (array[i] == USER) countUS++;
        }
        return countPC >= 2 || countUS >= 2;
    }

    static boolean isVictory(char player) {
        String winPlayer = "XXX";
        String winPC = "OOO";
        String diag1 = "";
        String diag2 = "";
        String vertical = "";
        String horizontal = "";

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                horizontal += MAP[i][j];
                vertical += MAP[j][i];
                if (horizontal.contains(winPC) || horizontal.contains(winPlayer) ||
                        vertical.contains(winPC) || vertical.contains(winPlayer))
                    return true;
            }
            vertical = "";
            horizontal = "";
        }

        for (int i = 0; i < SIZE; i++) {
            diag1 += (MAP[i][i]);
            diag2 += (MAP[i][(SIZE - 1) - i]);
        }
        return diag1.contains(winPlayer) || diag2.contains(winPlayer) || diag1.contains(winPC) || diag2.contains(winPC);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fillMap(3);
        printMap();
        System.out.println("Игра крестики-нолики! \n Вы играете за Х \n Для того, чтобы совершить ход: введите номер строки и номер столбца");
        while (isInGame) {
            System.out.println("Ваш ход:");
            int x, y;
            try {
                x = in.nextInt();
                y = in.nextInt();
            } catch (Exception e) {
                printMap();
                System.out.println("Введите корректные данные");
                in.nextLine();
                continue;
            }
            x--;
            y--;
            if (move(x, y, USER)) {
                printMap();
                if (isVictory(USER)) {
                    System.out.println("Вы победили!");
                    break;
                }
                try {
                    System.out.println("Ходит компьютер");
                    moveAI();
                    printMap();
                } catch (Exception e) {
                    System.out.println("Ничья");
                    break;
                }
                if (isVictory(PC)) {
                    System.out.println("Вы проиграли!");
                    break;
                }
            } else {
                printMap();
                System.out.println("Введите корректные данные");
            }
        }
    }
}
