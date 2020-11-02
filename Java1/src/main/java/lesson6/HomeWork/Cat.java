package lesson6.HomeWork;

public class Cat extends Animal {

    public Cat (String name){
        this.name = name;
        this.maxDistance = 200;
        this.maxSwimDistance = 0;
        this.maxHeight = 2;
    }

    public Cat(String name, int maxDistance, float maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }


    @Override
    public boolean canSwim(int distance) {
        System.out.println(name + " кот и не умеет плавать");
        return false;
    }


}
