import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @BeforeAll
    static void init(){}

    @Test
    void testPalindrome(){
        assertTrue(Palindrome.isPalindrome("alla"));
        assertTrue(Palindrome.isPalindrome("radar"));

        assertFalse(Palindrome.isPalindrome("java"));
        assertFalse(Palindrome.isPalindrome("tronald dump"));
    }

    @Test
    void testWhiteSpaces(){
        assertTrue(Palindrome.isPalindrome("innostunut sonni"));
        assertFalse(Palindrome.isPalindrome("tylsistynyt vasikka"));
    }

    @Test
    void testPunctuation(){
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal, Panama".toLowerCase()));
        assertTrue(Palindrome.isPalindrome("mom'n'mom"));
        assertFalse(Palindrome.isPalindrome("mom'n'dad"));
    }

    @Test
    void testCase(){
        assertTrue(Palindrome.isPalindrome("Mom"));
        assertTrue(Palindrome.isPalindrome("Dad"));
        assertFalse(Palindrome.isPalindrome("Diaper"));
    }

}
