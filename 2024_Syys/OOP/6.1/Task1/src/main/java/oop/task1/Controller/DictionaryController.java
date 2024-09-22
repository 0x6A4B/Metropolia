package oop.task1.Controller;

import oop.task1.Model.Dictionary;
import oop.task1.View.DictionaryView;

public class DictionaryController {
    private DictionaryView view;
    private Dictionary dict;

    public DictionaryController(DictionaryView view){
        this.view = view;
        dict = new Dictionary();
    }

    public void search(String word){
        String result = dict.getWord(word);
        view.searchResult((result != null) ? result : "Word not found!");
    }
    public void getSize(){ view.sizeResult(dict.getSize()); }
}
