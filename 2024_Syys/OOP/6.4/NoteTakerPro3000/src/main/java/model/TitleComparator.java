package model;

import java.util.Comparator;

public class TitleComparator implements Comparator<Note>{

    @Override
    public int compare(Note o1, Note o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
