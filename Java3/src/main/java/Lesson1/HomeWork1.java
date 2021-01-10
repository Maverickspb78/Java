package Lesson1;

public class HomeWork1 {

    public static void main(String[] args) {

//          1-task.

        TestArray<Integer> array = new TestArray<Integer>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        array.changeElements(1,5);
        System.out.println(array.toString());

//          2-task.

        System.out.println(array.transformation().getClass());

//          3-task.

        Box<Apple> appleBox= new Box<>();
        Box<Apple> appleBox2= new Box<>();

        appleBox.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox.moveAt(appleBox2);
        appleBox.info();
        appleBox2.info();
        appleBox.compare(appleBox2);
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        appleBox.getWeight();
        appleBox2.getWeight();
        orangeBox.getWeight();
        orangeBox.compare(appleBox2);


    }



}
