package lesson1;

public class HomeWork {
    public static void main(String[] args) {

    }

    public static void variables() {
        byte b = -128;
        short s = 32767;
        int i = 2147483647;
        long l = -9223372036854775808L;
        float f = 25.89f;
        double d = -256.257;
        char c = '*';
        boolean bool = true;
        String name = "Имя";
    }

    public static double calculated(double a, double b, double c, double d) {
        return (a * (b + (c / d)));
    }

    public static boolean sumInSegment(int a, int b) {
        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    public static void positiveOrNegative(int a) {
        if (a >= 0) System.out.println("number " + a + " - is positive");
        else System.out.println("number " + a + " - is negative");
    }

    public static boolean isNegative(int a) {
        if (a < 0) {
            return true;
        }
        return false;
    }

    public static void printHi(String name) {
        System.out.println("Привет, " + name);
    }

    public static void isLeap(int a) {
        if ((a % 400 == 0) || (a % 4 == 0) && (a % 100 != 0)) System.out.println(a + " - високосный год");
        else System.out.println(a + " - не високосный год");
    }
}