package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Note  implements Serializable {
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
    public LocalDateTime getModifiedDate(){ return modified; }

    public boolean contentEquals(Note note){ return text.equals(note); }


    @Override
    public String toString(){ return title; /*"Title: " + title + "\tUUID: " + id;*/ }
}
