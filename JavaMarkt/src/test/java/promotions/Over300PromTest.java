package promotions;
import cart.Cart;
import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.*;

public class Over300PromTest {

    @Test
    void discountApplied(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 160.0));
        cart.addProduct(new Product("Talerz", "T001", 150.0));
        cart.addPromotion(new Over300Prom());
        cart.applyPromotions();

        assertEquals(294.5, cart.getTotalPrice());
    }

    @Test
    void discountNotApplied(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 150.0));
        cart.addPromotion(new Over300Prom());
        cart.applyPromotions();

        assertEquals(250.0, cart.getTotalPrice());
    }
}
