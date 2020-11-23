package lesson1;

public class Human implements Actions {

    private static int count = 0;
    private int distanceRun;
    private float heightJump;
    private boolean mayGo = true;

    public Human(int distanceRun, float heightJump) {
        count++;
        this.distanceRun = distanceRun;
        this.heightJump = heightJump;
    }

    @Override
    public void run(int needRun) {
        if (mayGo) {
            if (distanceRun >= needRun) {
                System.out.println("Человек № " + count + " Успешно пробежал");
            } else {
                System.out.println("Человек № " + count +  " Не смог пробежаль");
                mayGo = false;
            }
        }
    }

    @Override
    public void jump(int needJump) {
        if (mayGo) {
            if (heightJump >= needJump) {
                System.out.println("Человек № " + count + " Успешно перепрыгнул");
            } else {
                System.out.println("Человек № " + count + " Не перепрыгнул");
                mayGo = false;
            }
        }
    }
}

