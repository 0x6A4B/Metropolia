package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.StringManipulator;

public class TestStringManipulator {

    @Test
    void canConcatenate(){
        StringManipulator sm = new StringManipulator();
        Assertions.assertEquals("abcdef", sm.concatenate("abc", "def"));
    }

    @Test
    void findsLength(){
        StringManipulator sm = new StringManipulator();
        Assertions.assertEquals(5, sm.findLength("abcde"));
    }

    @Test
    void convertsToUpperCase(){
        StringManipulator sm = new StringManipulator();
        Assertions.assertEquals("ABC", sm.convertToUpperCase("abc"));
    }

    @Test
    void convertsToLowerCase(){
        StringManipulator sm = new StringManipulator();
        Assertions.assertEquals("abc", sm.convertToLowerCase("ABC"));
    }

    @Test
    void findsSubstr(){
        StringManipulator sm = new StringManipulator();
        Assertions.assertTrue(sm.containsSubstring("abcdef", "de"));
    }
}
