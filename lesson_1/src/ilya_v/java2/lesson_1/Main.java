package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;
import ilya_v.java2.lesson_1.obstacles.Cross;
import ilya_v.java2.lesson_1.obstacles.Obstacle;
import ilya_v.java2.lesson_1.obstacles.Wall;
import ilya_v.java2.lesson_1.obstacles.Water;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {
                new Human("Иван"),
                new Cat("Леопольд"),
                new Dog("Творожок"),
                new Cat("Палач"),
                new Cat("Барсик III"),
        };

        Team[] teams = new Team[]{
                new Team("Команда А", new Human("Аркадий"), new Dog("Тузик"), new Cat("Белый Бим Черный Хвост Красный Ус")),
                new Team("Команда B", competitors),
        };

        //  метод вывода информации обо всех членах команды.
        for (Team team : teams) {
            System.out.println("Команда:");
            team.getAllParticipants();
            System.out.println();
        }

        //  метод для вывода информации о членах команды прошедших дистанцию
        Obstacle[] course = {
                new Cross(400),
                new Wall(8),
                new Water(10)
        };

        for (Team team : teams) {
            Competitor[] result = team.getAllSuccessfulParticipants(course);
            for (int i = 0; i <= result.length - 1; i++) {
                // Успешно прошли Аркадий и Белый Бим
                if (result[i] != null) {
                    System.out.println(result[i].getName() + ' ' + result[i].getType());
                }
            }
        }

        Course competition1 = new Course("Полоса препядствий №1", new Wall(1),
                new Wall(1), new Water(1), new Cross(1));

        Course competition2 = new Course("Полоса препядствий №1", new Wall(54),
                new Wall(75), new Water(678), new Cross(190));


        Team teamTest = new Team("Команда B", new Human("Глаша"), new Human("Черномырдин"), new Dog("Степашка"));

        competition1.resultOfCourse(new Team("Команда А", new Human("Аркадий"), new Dog("Тузик"), new Cat("Царапкин")));
        competition2.resultOfCourse(teamTest);
    }
}
