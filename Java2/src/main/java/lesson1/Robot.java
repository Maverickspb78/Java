package lesson1;

public class Robot implements Actions {

    private static int count = 0;
    private int distanceRun;
    private float heightJump;
    private boolean mayGo = true;

    public Robot(int distanceRun, float heightJump) {
        count++;
        this.distanceRun = distanceRun;
        this.heightJump = heightJump;
    }

    @Override
    public void run(int needRun) {
        if (mayGo) {
            if (distanceRun >= needRun) {
                System.out.println("Робот № " + count + " Успешно пробежал");
            } else {
                System.out.println("Робот № " + count + " Не пробежал");
                mayGo = false;
            }
        }
    }

    @Override
    public void jump(int needJump) {
        if (mayGo) {
            if (heightJump >= needJump) {
                System.out.println("Робот № " + count + " Успешно перепрыгнул");
            } else {
                System.out.println("Робот № " + count + " Не перепрыгнул");
                mayGo = false;
            }
        }
    }
}
