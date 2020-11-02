package lesson6.HomeWork;

public class Dog extends Animal {
    public Dog(String name){
        this.name = name;
        this.maxDistance = 500;
        this.maxSwimDistance = 10;
        this.maxHeight = 0.5f;
    }

    public Dog(String name, int maxDistance, int maxSwimDistance, float maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxHeight = maxHeight;
    }


}
