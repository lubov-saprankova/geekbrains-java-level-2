package ilya_v.java2.lesson_1;

import ilya_v.java2.lesson_1.competitors.*;

public class Team {
    String name;
    Competitor[] participants = new Competitor[4];

    public Team(String name, Competitor[] participants){
        this.name = name;
        this.participants = participants;
    }

    public void getAllParticipants(){
        for (int i = 0; i <= participants.length - 1; i++){
            System.out.println(participants[i]);
        }
    }


}
