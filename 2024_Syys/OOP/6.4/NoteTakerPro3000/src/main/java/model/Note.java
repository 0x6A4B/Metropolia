package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Note  implements Comparable<Note>, Serializable {
    private final UUID id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String title;
    private String text;
    private int edited;

    public Note(){
        id = UUID.randomUUID();
        created = LocalDateTime.now();
        modified = LocalDateTime.now();
        title = "untitled";
        text = "";
        edited = 0;
    }

    public void touch(){ modified = LocalDateTime.now(); }
    public UUID getId() { return id; }
    public String getCreated() { return created.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")); }
    public String getModified() { return modified.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")); }
    public String getText() { return text; }
    public String getTitle() { return title; }
    public void setText(String text) { this.text = text; edited++; }
    public void setTitle(String title) { this.title = title; }
    public int getEdited() { return edited; }

    @Override
    public int compareTo(Note note) {
        return -note.getModified().compareTo(getModified());
    }

    /*
    @Override
    public boolean equals(Object o){
        Note n = (Note) o;
        return n.getId().equals(id);
    }
*/
    @Override
    public String toString(){ return title; }
}
