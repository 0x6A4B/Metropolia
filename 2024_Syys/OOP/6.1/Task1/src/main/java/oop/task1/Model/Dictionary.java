package oop.task1.Model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary(){ dictionary = new HashMap<>(); }
    public void addWord(String language1, String language2){
        if (dictionary.containsKey(language1))
            dictionary.replace(language1, language2);
        else
            dictionary.put(language1, language2);
    }
    public String getWord(String word){
        if (dictionary.containsKey(word))
            return dictionary.get(word);
        return null;
    }
    public int getSize(){ return dictionary.size(); }
}
