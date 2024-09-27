package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class Notebook implements Serializable {
    private HashMap<UUID, Note> notes;


    public Notebook(){
        notes = new HashMap<>();
    }

    public void add(Note note){ notes.put(note.getId(), note); }
    public void remove(Note note){
        System.out.println("Removing note: " + note.getId() + " title: " + note.getTitle());
        System.out.println("Contains note: " + notes.containsKey(note.getId()));
        System.out.println(notes.remove(note.getId()));
        System.out.println("Notes: " + size());
    }
    public int size(){ return notes.size(); }
    public void update(Note note){
        note.touch();
        System.out.println("Contains note: " + notes.containsKey(note.getId()));
        System.out.println(notes.replace(note.getId(), note));
        System.out.println("Updated note: " + note.getId() + " title: " + note.getTitle());
    }
    public HashMap<UUID, Note> getNotes(){
        Collections.sort()
        return notes;
    }




//    public Note read(Note note){ notes.get(); }

/*
    public Note getNote(UUID id){
        Iterator iter = notes.iterator();
        while(iter.hasNext()) {
            Note n = (Note)iter.next();
            if (n.equals(id))
                return n;
        }
        return null;
    }
*/
}
