import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class test_task1{

    @BeforeAll
    static void init(){}

    @BeforeOne
    void setup(){}

    @AfterOne
    void done(){}


    @Test
    void testPalindrome(){
        assertTrue("alla");
        assertTrue("radar");

        assertFalse("java");
        assertFalse("trunald dump");
    }

    @Test
    void testWhiteSpaces(){
        assertTrue("innostunut sonni");

        assertFalse("tylsistynyt vasikka");
    }

    @Test
    void testPunctuation(){
        assertTrue("A man, a plan, a canal, Panama".toLowercase());
        assertTrue("mom'n'mom");
        assertFalse("mom'n'dad");
    }

    @Test
    void testCase(){
        assertTrue("Mom");
        assertTrue("Dad");
        assertFalse("Diaper");
    }

}
