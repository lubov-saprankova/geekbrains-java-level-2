package ilya_v.java2.lesson_1.obstacles;

import ilya_v.java2.lesson_1.competitors.Animal;
import ilya_v.java2.lesson_1.competitors.Competitor;

public class Water extends Obstacle {
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }
}
