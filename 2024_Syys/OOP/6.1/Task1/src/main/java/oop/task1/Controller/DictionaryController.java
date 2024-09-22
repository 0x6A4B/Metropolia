package oop.task1.Controller;

import oop.task1.Model.Dictionary;
import oop.task1.View.DictionaryView;
import oop.task1.Model.WordNotFoundException;

public class DictionaryController {
    private DictionaryView view;
    private Dictionary dict;

    public DictionaryController(DictionaryView view){
        this.view = view;
        dict = new Dictionary();
    }

    public void search(String word){
        String result;
        try {
            result = dict.getWord(word);
        }catch(WordNotFoundException e) {
            result = "Word not found!";
        }
        //view.searchResult((result != null) ? result : "Word not found!");
        view.searchResult(result);
    }
    public void getSize(){ view.sizeResult(dict.getSize()); }
}
