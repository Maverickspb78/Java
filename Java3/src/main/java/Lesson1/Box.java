package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list;

    public Box(T... obj) {
        list = Arrays.asList(obj);
    }

    public Box () {
        list = new ArrayList<T>();
    }

    public List<T> getList() {
        return list;
    }

    public void addFruit (T obj){
        list.add(obj);
    }

    public void moveAt (Box<T> box){
        box.getList().addAll(list);
        list.clear();
    }

    public void info (){
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
        }

    }

    public boolean compare (Box<? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }

    public float getWeight() {
        if (list.size() == 0) {
            return 0.0f;
        } else {
            float weight;
            weight = Math.abs((list.size()) * list.get(0).getWeight());
            System.out.println("Вес коробки: " + weight);
            return weight;
        }

    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}
