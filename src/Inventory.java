import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

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

    public int addProductQty(String productId, int addition) {
        if (products.containsKey(productId) && addition > 0)
            return products.get(productId).addQty(addition);

        return -1;
    }

    public int removeProductQty(String productId, int subtraction) {
        int productQty;
        if (products.containsKey(productId) && subtraction > 0) {
            productQty = products.get(productId).removeQty(subtraction);

            if (productQty == 0) removeProduct(productId);

            return productQty;
        }

        return -1;
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
