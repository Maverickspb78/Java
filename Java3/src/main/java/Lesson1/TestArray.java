package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray<T> {

    private T[] array;


    public TestArray(T...array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T changeElements(int index1, int index2){
        T temp;
        if ((index1 & index2)<array.length) {
            temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return (T) array;
    }

    @Override
    public String toString() {
        return "TestArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public ArrayList<T> transformation() {
        ArrayList<T> arrayList = new ArrayList<T>();
        arrayList.addAll(Arrays.asList(array));

        return arrayList;
    }
}
