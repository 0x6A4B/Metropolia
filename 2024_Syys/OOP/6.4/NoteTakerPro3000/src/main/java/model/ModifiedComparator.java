package model;

import java.util.Comparator;

public class ModifiedComparator implements Comparator<Note>{

    @Override
    public int compare(Note o1, Note o2) {
        return -o1.getModifiedDate().compareTo(o2.getModifiedDate());
    }
}
