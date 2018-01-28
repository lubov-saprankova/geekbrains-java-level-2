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

        Obstacle[] course = {
                new Cross(400),
                new Wall(8),
                new Water(10)
        };

        /*
        for (Competitor a: competitors) {
            for(Obstacle o : course){
                o.doIt(a);
                if (!a.isOnDistance()) break;
            }
        }
        System.out.println("=======================");
        for (Competitor a: competitors){
            a.showResult();
        }*/

        Team[] teams = new Team[]{
                new Team("Команда А", new Human("Аркадий"), new Dog("Тузик") ,  new Cat("Белый Бим Черный Хвост Красный Ус")),
                new Team("Команда B", competitors),
        };

        for (Team team : teams) {
            System.out.println("Команда:");
            team.getAllParticipants();
            System.out.println();
        }




        /*
        System.out.println(teams[0].name);
        for (Competitor c : teams[0].participants){
            System.out.println((Human)c.name);
        }

        /*
        for (participant : teams[0].participants)


            for (Competitor a: participant) {
            for (Obstacle o : course) {
                o.doIt(a);
            }
        }*/


    }
}
