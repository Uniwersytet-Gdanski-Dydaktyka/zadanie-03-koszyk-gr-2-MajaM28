package promotions;

import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Over200Gift implements Promotion{
    @Override
    public List<Product> apply(List<Product> products) {
        double sum = 0;
        for (Product prod : products) {
            sum += prod.getPrice();
        }
        if (sum <= 200) {
            return products;
        }

        List<Product> result = new ArrayList<>(products);
        Product kubek = new Product("kubek","0000",0.0,0.0);
        result.add(kubek);
        return result;
    }
}
