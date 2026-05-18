package cart;

import org.junit.jupiter.api.Test;
import product.Product;
import promotions.UseCoupon;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FinderTest {

    @Test
    void findCheapest(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 50.0));
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Łyżka", "L001", 10.0));
        cart.addProduct(new Product("Nóż", "N001", 5.0));


        Product cheapest = cart.findCheapest();
        assertEquals(5.0, cheapest.getPrice());
    }

    @Test
    void findMostExpensive(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 50.0));
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Łyżka", "L001", 10.0));
        cart.addProduct(new Product("Nóż", "N001", 5.0));


        Product mostExp = cart.findMostExpensive();
        assertEquals(100.0, mostExp.getPrice());
    }

    @Test
    void findCheapestEmptyList(){
        Cart cart = new Cart();


        Product mostExp = cart.findCheapest();
        assertNull(mostExp);
    }

    @Test
    void findNMostExpensive(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 50.0));
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Łyżka", "L001", 10.0));
        cart.addProduct(new Product("Nóż", "N001", 5.0));


        List<Product> mostExp = cart.findNMostExpensive(3);
        assertEquals(100.0, mostExp.get(0).getPrice());
        assertEquals(90.0, mostExp.get(1).getPrice());
        assertEquals(50.0, mostExp.get(2).getPrice());
    }

    @Test
    void findNCheapest(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 50.0));
        cart.addProduct(new Product("Widelec", "W001", 90.0));
        cart.addProduct(new Product("Łyżka", "L001", 10.0));
        cart.addProduct(new Product("Nóż", "N001", 5.0));


        List<Product> mostExp = cart.findNCheapest(3);
        assertEquals(5.0, mostExp.get(0).getPrice());
        assertEquals(10.0, mostExp.get(1).getPrice());
        assertEquals(50.0, mostExp.get(2).getPrice());
    }
}
