package promotions;

import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UseCoupon implements Promotion{
    private final String productCode;
    private final double discount;
    private boolean used = false;

    public UseCoupon(String productCode, double discount){
        this.productCode = productCode;
        this.discount = discount;
    }


    @Override
    public List<Product> apply(List<Product> products) {
        if (this.used){
            return products;
        } else {
            List<Product> discounted = new ArrayList<>();
            for (Product prod : products){
                if (Objects.equals(prod.getCode(), productCode)){
                    discounted.add(prod.withDiscount(prod.getPrice()* (1-discount)));
                } else {
                    discounted.add(prod);
                }
            }
            this.used = true;
            return discounted;
        }
    }
}
