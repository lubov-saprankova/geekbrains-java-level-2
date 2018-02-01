package ilya_v.java2.lesson_3;

import java.util.HashMap;

/**
 * @param phonebookRecord userName phoneNumber
 */
public class Phonebook {
    public HashMap<String, String> phoneRecord = new HashMap<>();

    public Phonebook(){
        this.phoneRecord.put("Пупкин Иван", "8(999)123-32-12");
        this.phoneRecord.put("Аристарх Арсенович Шмутьковато", "8(926)783-49-27");
    }

    public void add(String userName, String phoneNumber){
        this.phoneRecord.put(userName, phoneNumber);
    }

    public String get(String userName){
        return this.phoneRecord.get(userName);
    }
}
