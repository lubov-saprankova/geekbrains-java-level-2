package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;
import ilya_v.java2.lesson_1.obstacles.Cross;
import ilya_v.java2.lesson_1.obstacles.Obstacle;
import ilya_v.java2.lesson_1.obstacles.Wall;
import ilya_v.java2.lesson_1.obstacles.Water;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] course = {new Cross(400), new Wall(8), new Water(10)};

        for (Competitor a: competitors) {
            for(Obstacle o : course){
                o.doIt(a);
                if (!a.isOnDistance()) break;
            }
        }
        System.out.println("=======================");
        for (Competitor a: competitors){
            a.showResult();
        }
    }
}
