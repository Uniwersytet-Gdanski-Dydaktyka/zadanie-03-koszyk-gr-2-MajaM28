package promotions;
import product.Product;
import java.util.List;

public interface Promotion {
    public List<Product> apply(List<Product> products);
}