package cart;

import product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Finder {


    public Product findCheapest (List<Product> products){
        if (products == null || products.isEmpty()) {
            return null;
        }
        int size = products.size();
        Product cheapest = products.getFirst();
        for (int i=0; i < size; i++ ){
            if (products.get(i).getPrice() < cheapest.getPrice()){
                cheapest = products.get(i);
            }
        }
        return cheapest;
    }

    public Product findMostExpensive (List<Product> products){
        if (products == null || products.isEmpty()) {
            return null;
        }
        int size = products.size();
        Product mostExpensive = products.getFirst();
        for (int i=0; i < size; i++ ){
            if (products.get(i).getPrice() > mostExpensive.getPrice()){
                mostExpensive = products.get(i);
            }
        }
        return mostExpensive;
    }

    public List<Product> findNCheapest (List<Product> products, int n){
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }
        List<Product> copy = new ArrayList<>(products);
        copy.sort(Comparator.comparingDouble(Product :: getPrice));
        return copy.subList(0, Math.min(n, copy.size()));
    }

    public List<Product> findNMostExpensive (List<Product> products, int n){
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }
        List<Product> copy = new ArrayList<>(products);
        copy.sort(Comparator.comparingDouble(Product :: getPrice).reversed());
        return copy.subList(0, Math.min(n, copy.size()));
    }
}
