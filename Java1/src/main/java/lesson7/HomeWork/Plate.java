package lesson7.HomeWork;

public class Plate {
    private String namePlate;
    private int food;

    public Plate(String namePlate, int food) {
        this.namePlate = namePlate;
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void info() {
        System.out.println(namePlate + ": осталось " + food + " едениц еды");
    }

    public void addFood(int f) {
        food += f;
        System.out.println("В " + namePlate + " добавленно " + f + " едениц еды");
    }

    public int getFood() {
        return food;
    }

    public String getNamePlate() {
        return namePlate;
    }
}
