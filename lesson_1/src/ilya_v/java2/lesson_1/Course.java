package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;
import ilya_v.java2.lesson_1.obstacles.*;

/**
 * 3. Добавить класс Course (полоса препятствий),
 * в котором будут находиться: массив препятствий,
 * метод который будет просить команду пройти всю полосу;
 */
public class Course {
    String name;

    Obstacle[] obstacles;

    public Course(String name, Obstacle... obstacles){
        this.name = name;
        this.obstacles = obstacles;
    }

    public boolean resultOfCourse(Team team){
        Competitor[] result = team.getAllSuccessfulParticipants(this.obstacles);

        return result.length > 1;
    }

}
