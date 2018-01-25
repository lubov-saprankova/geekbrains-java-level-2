package ilya_v.java2.lesson_1.obstacles;

import ilya_v.java2.lesson_1.competitors.Animal;
import ilya_v.java2.lesson_1.competitors.Competitor;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
