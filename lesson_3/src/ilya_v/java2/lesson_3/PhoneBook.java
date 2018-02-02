package ilya_v.java2.lesson_3;

import java.util.HashMap;

/**
 * @param phonebookRecord userName phoneNumber
 */
class PhoneBook {
    private HashMap<String, String> phoneRecord = new HashMap<>();

    PhoneBook(){
        this.phoneRecord.put("Пупкин Иван", "8(999)123-32-12");
        this.phoneRecord.put("Аристарх Арсенович Шмутьковато", "8(926)783-49-27");
    }

    void add(String userName, String phoneNumber){
        this.phoneRecord.put(userName, phoneNumber);
    }

    String get(String userName){
        return this.phoneRecord.get(userName);
    }
}
