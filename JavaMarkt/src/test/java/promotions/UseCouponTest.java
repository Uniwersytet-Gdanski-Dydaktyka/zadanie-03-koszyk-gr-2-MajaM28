package promotions;

import cart.Cart;
import org.junit.jupiter.api.Test;
import product.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCouponTest {

    @Test
    void couponApplied(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        cart.addPromotion(new UseCoupon("K001",0.30));

        cart.applyPromotions();

        assertEquals(70.0, cart.getProducts().getFirst().getDiscountPrice());
    }

    @Test
    void couponUsedOnce(){
        Cart cart = new Cart();
        cart.addProduct(new Product("Kubek", "K001", 100.0));
        UseCoupon coupon = new UseCoupon("K001", 0.30);
        cart.addPromotion(coupon);
        cart.addPromotion(coupon);
        cart.applyPromotions();

        assertEquals(70.0, cart.getProducts().getFirst().getDiscountPrice());
    }
}
