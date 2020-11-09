package lesson7.HomeWork;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.getFood() > appetite && satiety == false) {
            p.decreaseFood(appetite);
            satiety = true;
            System.out.println("Кот " + name + " съел " + appetite + " еды");
        } else System.out.println(satiety? "Кот " + name +" не голоден и не поел" : "В "+ p.getNamePlate() +
         " не хватает еды, а коту " + name + " нужно " + appetite + " едениц еды");

    }

    public void printSatiety() {
        System.out.println(satiety ? "Кот " + name + " не голоден" : "Кот " + name + " голоден ему нужно" +
                appetite + " едениц еды");
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
