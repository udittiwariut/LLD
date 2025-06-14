package vendingmachine;

import java.util.HashMap;

public class Inventory {
    private final HashMap<Product, Integer> productQuantities;

    public Inventory() {
        productQuantities = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        productQuantities.put(product, quantity);
    }

    public void reduceQuantity(Product product) {
        productQuantities.put(product, productQuantities.get(product) - 1);
    }

    public void increaseQuantity(Product product) {
        productQuantities.put(product, productQuantities.get(product) + 1);
    }

    public int getProductQuantities(Product product) {
        return productQuantities.get(product);
    }

    public boolean isAvailable(Product product) {
        return productQuantities.containsKey(product) && productQuantities.get(product) > 0;

    }

}