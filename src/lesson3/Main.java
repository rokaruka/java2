package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Первое задание
        String[] arr = {"cat", "dog", "duck", "rabbit", "cat", "dog", "elephant", "pigon", "dog", "cat", "duck"};

        Map<String, Integer> wordList = new HashMap<>();
        for (int i = 0;i< arr.length;i++) {
            String key = arr[i];
            int count = wordList.getOrDefault(key, 0);
            wordList.put(key, count + 1);
        }
        System.out.println(wordList);

        //Второе задание
        PhoneBook phbook = new PhoneBook();
        phbook.add("anton", "93423423");
        phbook.add("anton", "21312123");
        phbook.add("vasya", "94593453");
        System.out.println(phbook.get("anton"));

    }
}

