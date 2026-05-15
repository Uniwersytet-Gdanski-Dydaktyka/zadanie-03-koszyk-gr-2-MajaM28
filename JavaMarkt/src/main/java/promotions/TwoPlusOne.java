package promotions;
import product.Product;
import java.util.ArrayList;
import java.util.List;


public class TwoPlusOne implements Promotion{
    @Override
    public List<Product> apply(List<Product> products) {
        int size = products.size();
        if (size < 3 ){
            return products;
        } else {
            Product cheapest = products.getFirst();
            for (int i=0; i < size; i++ ){
                if (products.get(i).getPrice() < cheapest.getPrice()){
                    cheapest = products.get(i);
                }
            }
            List<Product> discounted = new ArrayList<>();
            for (Product prod : products) {
                if (prod.equals(cheapest)) {
                    discounted.add(prod.withDiscount(0.0));
                } else {
                    discounted.add(prod);
                }
            }
            return discounted;
        }
    }
}
