package com.example.ex2.repository;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("dog", "con cho");
        dictionary.put("cat", "con meo");
        dictionary.put("rabbit", "con tho");
        dictionary.put("alligator", "ca sau");
        dictionary.put("fish", "ca");
        dictionary.put("dolphin", "ca heo");
        dictionary.put("whale", "ca voi");
        dictionary.put("otter", "rai ca");
        dictionary.put("tiger", "con ho");
        dictionary.put("lion", "su tu");
    }

    @Override
    public String lookUp(String word) {
        if (dictionary.get(word) != null) {
            return dictionary.get(word);
        } else {
            return "Cannot find the word in Vietnamese!";
        }
    }
}
