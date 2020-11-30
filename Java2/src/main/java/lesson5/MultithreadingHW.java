package lesson5;

public class MultithreadingHW {

    private static final Formula formula = new Formula();


    public static void main(String[] args) throws InterruptedException {
        final int size = 10000000;
        float[] arr = new float[size];

        final int size2 = 10000000;
        final int h = size2 / 2;
        float[] arr2 = new float[size2];

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Без многопоточности: " + (System.currentTimeMillis() - a));

        long b = System.currentTimeMillis();

        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);

        Runnable calc1 = () -> {
            synchronized (formula) {
                formula.formula(a1);
            }
        };

        Runnable calc2 = () -> {
            formula.formula(a2);
        };

        Thread thread1 = new Thread(calc1);
        Thread thread2 = new Thread(calc2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);

        System.out.println("С многопоточностью: " + (System.currentTimeMillis() - b));

    }
}
