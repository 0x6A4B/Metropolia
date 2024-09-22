package oop.task1.Model;

import java.util.HashMap;
import java.util.Map;
import oop.task1.Model.WordNotFoundException;

public class Dictionary{
    private HashMap<String, String> dictionary;

    public Dictionary(){
        dictionary = new HashMap<>();
        // for example/demo
        addWord("Word", "Sana");
        addWord("This", "Tämä");
        addWord("Bad", "Huono");
        addWord("Program", "Ohjelma");
        addWord("Bad", "Hyvä"); // nyt ohjelma on hyvä :) korjattu
    }
    public void addWord(String language1, String language2){
        if (dictionary.containsKey(language1))
            dictionary.replace(language1, language2);
        else
            dictionary.put(language1, language2);
    }
    // we'll decide to translate both ways
    public String getWord(String word) throws WordNotFoundException{
        word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length()).toLowerCase();
        System.out.println(word);
        if (dictionary.containsKey(word))
            return dictionary.get(word);
        else
            if (dictionary.containsValue(word))
                for (Map.Entry<String, String> entry : dictionary.entrySet())
                    if (entry.getValue().equals(word))
                        return entry.getKey();
        throw new WordNotFoundException();
        //return null;
    }
    public int getSize(){ return dictionary.size(); }

}
