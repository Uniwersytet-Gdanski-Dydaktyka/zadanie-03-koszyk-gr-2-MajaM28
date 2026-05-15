package promotions;
import product.Product;
import java.util.ArrayList;
import java.util.List;

public class Over300Prom implements Promotion{
    @Override
    public List<Product> apply(List<Product> products) {
        double sum = 0;
        for (Product prod : products) {
            sum += prod.getPrice();
        }
        if (sum <= 300) {
            return products;
        }
        List<Product> discounted = new ArrayList<>();
        for (Product prod: products) {
            discounted.add(prod.withDiscount(prod.getPrice() * 0.95));
        }
        return discounted;
    }
}
