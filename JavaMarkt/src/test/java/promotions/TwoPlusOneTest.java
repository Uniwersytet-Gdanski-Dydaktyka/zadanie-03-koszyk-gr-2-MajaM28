package promotions;

import cart.Cart;
import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPlusOneTest {

    @Test
    void cheapestIsFree(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 10.0));
        cart.addProduct(new Product("Talerz", "T001", 12.0));
        cart.addProduct(new Product("Widelec", "W001", 5.0));
        cart.addPromotion(new TwoPlusOne());
        cart.applyPromotions();

        Product cheapest = cart.getProducts().get(0);
        for (Product p : cart.getProducts()) {
            if (p.getDiscountPrice() < cheapest.getDiscountPrice()) {
                cheapest = p;
            }
        }

        assertEquals(0.0, cheapest.getDiscountPrice());
    }

    @Test
    void lessThanThreeProducts(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 10.0));
        cart.addProduct(new Product("Talerz", "T001", 12.0));
        cart.addPromotion(new TwoPlusOne());
        cart.applyPromotions();

        assertEquals(22.0,  cart.getTotalPrice());
    }
}
