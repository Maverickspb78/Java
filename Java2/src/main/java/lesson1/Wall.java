package lesson1;

public class Wall implements Course {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void take(Actions actions) {
        actions.jump(height);
    }
}
