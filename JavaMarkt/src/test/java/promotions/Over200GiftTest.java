package promotions;

import cart.Cart;
import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Over200GiftTest {
    @Test
    void giftAdded(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 110.0));
        cart.addPromotion(new Over200Gift());

        cart.applyPromotions();

        assertEquals(3, cart.getProducts().size());
    }

    @Test
    void giftNotAdded(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addProduct(new Product("Talerz", "T001", 90.0));
        cart.addPromotion(new Over200Gift());

        cart.applyPromotions();

        assertEquals(2, cart.getProducts().size());
    }

}
