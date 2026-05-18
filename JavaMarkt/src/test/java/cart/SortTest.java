package cart;

import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    @Test
    void sortByPriceDescending(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Łyżka", "L001", 10.0));
        cart.addProduct(new Product("Nóż", "N001", 5.0));

        cart.sortProducts();
        assertEquals(90.0, cart.getProducts().getFirst().getPrice());
        assertEquals(5.0, cart.getProducts().getLast().getPrice());
    }

    @Test
    void sortByNameWhenSamePrice(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Talerz", "T001", 90.0));


        cart.sortProducts();
        assertEquals("Talerz", cart.getProducts().getFirst().getName());
        assertEquals("Widelec", cart.getProducts().getLast().getName());
    }
}
