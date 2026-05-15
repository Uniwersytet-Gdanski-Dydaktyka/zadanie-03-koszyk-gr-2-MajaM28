package cart;

import java.util.ArrayList;
import java.util.List;

import product.Product;
import promotions.Promotion;


import java.util.Comparator;

public class Cart {
    private List<Product> products;
    private Comparator<Product> comparator;
    private List<Promotion> promotions = new ArrayList<>();
    private final Finder finder = new Finder();


    public Cart(){
        this.products = new ArrayList<>();
        this.comparator = Comparator.comparingDouble(Product::getPrice).reversed()
                .thenComparing(Product::getName);
    }

    public Cart(List<Product> products){
        this.products = new ArrayList<>(products);
        this.comparator = Comparator.comparingDouble(Product::getPrice).reversed()
                .thenComparing(Product::getName);
    }

    public void addProduct (Product product){
        if (product == null) return;
        products.add(product);
    }

    public void removeProduct (Product product){
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products); // kopia, żeby nie można było modyfikować z zewnątrz
    }

    public double getTotalPrice(){
        double sum = 0;
        for (Product prod: products){
           sum += prod.getDiscountPrice();
        }
        return sum;
    }

    public void sortProducts(){
        products.sort(comparator);
    }

    public void setComparator(Comparator<Product> comparator) {
        this.comparator = comparator;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public void applyPromotions() {
        if (products == null || products.isEmpty()) return;
        for (Promotion prom : promotions) {
            products = prom.apply(products);
        }
    }

    public Product findCheapest(){
        return finder.findCheapest(products);
    }

    public Product findMostExpensive() {
        return finder.findMostExpensive(products);
    }

    public List<Product> findNCheapest(int n) {
        return finder.findNCheapest(products, n);
    }

    public List<Product> findNMostExpensive(int n) {
        return finder.findNMostExpensive(products, n);
    }
}
