import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class TestShoppingCart {

    @BeforeEach
    void init(){}

    /* It's a bit silly asserting true and false as that's what the assertEquals finds out */
    /* But why not? Let's be pedantic, and I wasn't really able to come up with anything new anyway */

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();

        assertTrue(cart.addItem("Apple", 1.0));
        assertTrue(cart.addItem("Banana", 0.5));
        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();

        assertTrue(cart.addItem("Apple", 1.0));
        assertTrue(cart.addItem("Banana", 0.5));
        assertFalse(cart.addItem("House", -1)); // not adding negative prices
        assertTrue(cart.removeItem("Apple"));
        assertEquals(1, cart.getItemCount());

        assertTrue(cart.addItem("Tea", 2.0));
        assertTrue(cart.addItem("Milk", 2.5));
        assertTrue(cart.addItem("Corn", 2.5));
        assertTrue(cart.removeItem("Tea"));
        assertFalse(cart.removeItem("Tyre")); // not removing as it won't exist

        assertEquals(3, cart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        assertTrue(cart.addItem("Apple", 1.0));
        assertTrue(cart.addItem("Banana", 0.5));
        assertTrue(cart.addItem("Orange", 0.75));
        assertFalse(cart.addItem("Moon", -75)); // not adding negative price
        assertFalse(cart.removeItem("Crabapple")); // not removing non-existing items
        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }

}
