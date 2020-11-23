package lesson2;

public class Exep {
    public static void main(String[] args) {

        String[][] arr;
        int sum = 0;
        try {
            arr = initArray(4,4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "] находится тип отличный от int." );
                }
            }
        System.out.println("Сумма массива = " + sum);
    }

    public static String[][] initArray(int row, int col)  {
        if (row != 4 || col != 4) {
            throw new MyArraySizeException("Массив не 4х4");
        }
        String[][] arr = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"}
        };

        return arr;
    }
}
