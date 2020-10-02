package lesson3;

import java.util.*;

public class PhoneBook {
//
    private HashMap< String, ArrayList<String>> book = new HashMap<>();

    public void add(String username,String phone){

        ArrayList<String> phlist = book.get(username);
        if (phlist == null){
            phlist = new ArrayList<>();
        }
            phlist.add(phone);
            book.put(username, phlist);
        };


//    public String get(String name){      /* выводит только уникальные значения */
//        return book.get(name);
//    };
    public ArrayList<String> get(String username){
        return book.get(username);
    };
}
