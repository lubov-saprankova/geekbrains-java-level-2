package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;

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


}
