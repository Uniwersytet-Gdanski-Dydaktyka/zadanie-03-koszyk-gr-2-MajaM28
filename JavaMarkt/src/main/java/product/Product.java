package product;

import java.util.Objects;

public class Product {

    private final String code;
    private final String name;
    private final double price;
    private final double discountPrice;

    public Product(String name, String code, double price, double discountPrice) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public Product withDiscount(double discountPrice){
       return new Product(this.name,this.code,this.price,discountPrice);
    }

    public Product(String name, String code, double price) {
        this(name, code, price, price);
    }


    public String getCode() {return code; }
    public String getName() {return name; }
    public double getPrice() {return price; }
    public double getDiscountPrice() {return discountPrice;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
