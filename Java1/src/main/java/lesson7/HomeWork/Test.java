package lesson7.HomeWork;


public class Test {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        String name = "Barsik";
        Plate plate = new Plate("Plate number 1", ((int)(Math.random()*30)));
        catsT(cats);
        plate.info();
        plate.addFood(10);
        plate.info();
        System.out.println();
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println();

        for (Cat cat : cats) {
            cat.printSatiety();
        }
        System.out.println();
        plate.info();
        plate.addFood(50);
        System.out.println();
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println();
        for (Cat cat : cats) {
            cat.printSatiety();
        }
        plate.info();
    }

    public static Cat[] catsT(Cat[] cats) {
        String name = "Barsik";
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(name + " "+ (i + 1), ((int) (Math.random() * 10)));
        }
        return cats;
    }
}
