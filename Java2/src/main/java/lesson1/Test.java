package lesson1;

import java.util.ArrayList;


public class Test {

    public static void main(String[] args) {

        ArrayList<Actions> participants = new ArrayList<Actions>();
        participants.add(new Human(100, 1));
        participants.add(new Robot(700, 2));
        participants.add(new Cat(200, 3));

        ArrayList<Course> course = new ArrayList<>();
        course.add(new Wall(1));
        course.add(new Treadmill(100));
        course.add(new Wall(2));
        course.add(new Treadmill(400));
        course.add(new Wall(3));
        course.add(new Treadmill(600));

        for (Actions par : participants) {
            for (Course cour : course) {
                cour.take(par);

            }
        }
    }
}
