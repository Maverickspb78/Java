package lesson6.HomeWork;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Bars", 300, 1.5f);
        Cat cat2 = new Cat("Reyna");
        cat1.canRun(-2);
        cat1.canSwim(20);
        cat1.canJump(1.2f);
        System.out.println();
        cat2.canRun(150);
        cat2.canSwim(-1);
        cat2.canJump(5);

        System.out.println();

        Dog dod1 = new Dog("Strelka", 400, 8, 1f);
        Dog dog2 = new Dog("Peshka");
        dod1.canRun(300);
        dod1.canJump(2);
        dod1.canSwim(9);
        System.out.println();
        dog2.canRun(-20);
        dog2.canJump(0.3f);
        dog2.canSwim(15);


    }


}
