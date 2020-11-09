package lesson6.HomeWork;

public abstract class Animal {
    public int maxDistance, maxSwimDistance;
    public float maxHeight;
    public String name;

    public boolean canRun(int distance) {
        System.out.println(name + ".canRun(" + distance + ") : " +
                ((distance < maxDistance) && (distance > 0)) + ". " + name + " может пробежать" +
                " максимум " + this.maxDistance + " метров");
        return distance < maxDistance;
    }

    public boolean canSwim(int distance) {
        System.out.println(name + ".canSwim(" + distance + ") : " +
                ((distance < maxSwimDistance) && distance > 0) + ". " + name + " может проплыть" +
                " максимум " + this.maxSwimDistance + " метров");
        return distance < maxDistance;
    }

    public boolean canJump(float height) {
        System.out.println(name + ".canJump(" + height + ") : " +
                ((height < maxHeight) && height > 0) + ". " + name + " может прыгнуть" +
                " максимум на " + this.maxHeight + " метров");
        return height < maxDistance;
    }
}
