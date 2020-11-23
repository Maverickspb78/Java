package lesson1;

public class Cat implements Actions {

    private static int count = 0;
    private int distanceRun;
    private float heightJump;
    private boolean mayGo = true;

    public Cat(int distanceRun, float heightJump) {
        count++;
        this.distanceRun = distanceRun;
        this.heightJump = heightJump;
    }

    @Override
    public void run(int needRun) {
        if (mayGo) {
            if (distanceRun >= needRun) {
                System.out.println("Кот № " + count + " Успешно пробежал");
            } else {
                System.out.println("Кот № " + count + " Не смог пробежаль");
                mayGo = false;
            }
        }
    }

    @Override
    public void jump(int needJump) {
        if (mayGo) {
            if (heightJump >= needJump) {
                System.out.println("Кот № " + count + " Успешно перепрыгнул");
            } else {
                System.out.println("Кот № " + count + " Не перепрыгнуть");
                mayGo = false;
            }
        }
    }
}
