package cart;
import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    @Test
    void getTotalPrice(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 10.0));
        cart.addProduct(new Product("Talerz", "T001", 20.0));
        assertEquals(30.0, cart.getTotalPrice());
    }

    @Test
    void getTotalPriceEmptyCart(){
        Cart cart = new Cart();
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    void addProduct(){
        Cart cart = new Cart();
        Product product = new Product("Kubek", "K001", 10.0);
        cart.addProduct(product);
        assertTrue(cart.getProducts().contains(product));
    }

    @Test
    void removeProduct(){
        Cart cart = new Cart();
        Product product = new Product("Kubek", "K001", 10.0);
        cart.addProduct(product);
        cart.removeProduct(product);
        assertEquals(0, cart.getProducts().size());
    }

}
