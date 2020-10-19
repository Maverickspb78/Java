package lesson2;


import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        //Exercise №1
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }

        //Exercise №2
        int[] a = new int[8];
        int c = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = c;
            c += 3;
        }

        //Exercise №3
        int[] b = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < b.length; i++) {
            if (b[i] < 6) b[i] *= 2;
        }

        //Exercise №4

        int[][] d = new int[9][9];
        int n = 0;

        for (int i = 0; i < d.length; i++) {
            d[i][i] = 1;
            d[i][(d.length - 1) - n] = 1;
            n++;
        }

        //Exercise №5

        int[] e = new int[20];
        for (int i = 0; i < e.length; i++) {
            e[i] = (int) (Math.random() * 100);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < e.length; i++) {
            if (min > e[i]) min = e[i];
            else if (max < e[i]) max = e[i];
        }
    }

    //Exercise №6

    public static boolean checkBalance(int[] a) {
        boolean check = false;
        int n = 1, l = 1, r = a.length - 2;

        int left = a[0], right = a[a.length - 1];
        while (n <= a.length - 2) {
            if (left <= right) {
                left = left + a[l];
                l++;
            } else {
                right = right + a[r];
                r--;
            }
            n++;
        }
        if (left == right) check = true;
        return check;
    }

    //Exercise №7

    public static int[] shiftArray(int[] a, int shift) {
        if (shift == 0) return a;

        int temp = 0;

        //для положительного shift
        if (shift > 0) {
            //считаем число сдвигов
            if (shift > a.length) shift = shift % a.length;

            //сдвигаем ->
            for (int i = 0; i < shift; i++) {
                temp = a[a.length - 1];
                for (int j = a.length - 1; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = temp;
            }

            // для отрицательного shift
            // сдвигаем <-
        } else {
            if (Math.abs(shift) > a.length) shift = (Math.abs(shift) % a.length);
            else shift = Math.abs(shift);
            for (int i = 0; i < shift; i++) {
                temp = a[0];
                for (int j = 0; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[a.length - 1] = temp;
            }
        }

        return a;
    }

}
