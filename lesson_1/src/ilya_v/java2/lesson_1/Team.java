package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;
import ilya_v.java2.lesson_1.obstacles.Obstacle;

/**
 * 2. Добавить класс Team, который будет содержать:
 * название команды,
 * массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
 * метод для вывода информации о членах команды прошедших дистанцию,
 * метод вывода информации обо всех членах команды.
 */
public class Team {
    String name;
    Competitor[] participants;

    public Team(String name, Competitor... participants){
        this.name = name;
        this.participants = participants;
    }

    public void getAllParticipants(){
        for (Competitor a: this.participants){
            System.out.println(a.getName() + " | " + a.getType());
        }
    }

    public boolean getResultOfTest(Competitor a, Obstacle[] course){
        for (Obstacle o : course) {
            o.doIt(a);
            if (!a.isOnDistance()) return false;
        }
        return true;
    }

    public Competitor[] getAllSuccessfulParticipants(Obstacle[] course){
        Competitor[] result = new Competitor[this.participants.length];
        int i = 0;
        for (Competitor a: this.participants){
           if (this.getResultOfTest(a, course)){
               result[i] = a;
               i++;
           }
        }
        return  result;
    }




}
