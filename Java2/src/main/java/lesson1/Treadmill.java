package lesson1;

public class Treadmill implements Course {

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void take(Actions actions) {
        actions.run(distance);
    }
}
