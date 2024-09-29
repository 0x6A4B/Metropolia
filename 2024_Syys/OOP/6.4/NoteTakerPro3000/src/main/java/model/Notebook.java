package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Notebook implements Serializable {
    private ArrayList<Note> notes;


    public Notebook(){
        notes = new ArrayList<>();
    }

    public void add(Note note){ notes.add(note); }
    public void remove(Note note){
        System.out.println("Removing note: " + note.getId() + " title: " + note.getTitle());
        System.out.println("Contains note: " + notes.contains(note));
        System.out.println(notes.remove(note));
        System.out.println("Notes: " + size());
    }
    public int size(){ return notes.size(); }
    public boolean update(Note note){
        if (notes.get(notes.indexOf(note)).contentEquals(note))
            return false;
        note.touch();
        System.out.println("Contains note: " + notes.contains(note));
        System.out.println(notes.set(notes.indexOf(note), note));
        System.out.println("Updated note: " + note.getId() + " title: " + note.getTitle());
        return true;
    }

    public ArrayList<Note> getNotes(){
        Collections.sort(notes, new ModifiedComparator());
        return notes;
    }

    // this could be used for alternate sorting of notes
    public ArrayList<Note> getNotesByTitle(){
        Collections.sort(notes, new TitleComparator());
        return notes;
    }



}
