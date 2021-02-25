import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public boolean addProduct(String productId, double price, int qty) {
        if (!products.containsKey(productId)) {
            products.put(productId, new Product(productId, price, qty));
            return true;
        }

        return false;
    }

    public boolean removeProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            return true;
        }

        return false;

    }

    public boolean addProductQty(String productId, int addition) {
        if (products.containsKey(productId) && addition > 0) {
            products.get(productId).addQty(addition);
            return true;
        }

        return false;
    }

    public boolean removeProductQty(String productId, int subtraction) {
        if (products.containsKey(productId) && subtraction > 0) {
            products.get(productId).removeQty(subtraction);

            if (products.get(productId).getQty() == 0) removeProduct(productId);

            return true;
        }

        return false;
    }

    public double getProductTotalPrice(String productId) {
        if (products.containsKey(productId))
            return products.get(productId).totalPrice();

        return -1;
    }

    public double getInventoryPrice() {
        double total = 0;
        for (Product product : products.values()) {
            total += product.totalPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        String output = String.format("Inventory price is %.2f\n", getInventoryPrice());
        for (Product product : products.values()) {
            output += String.format("%s total price is %.2f\n", product.getId(), product.totalPrice());
        }

        return output;
    }
}
