public class Product {
    private final String id;
    private final double price;
    private int qty;

    public Product(String id, double price, int qty) {
        this.id = id;
        this.price = price;
        this.qty = qty;
    }

    public int addQty(int addition) {
        qty += addition;

        return qty;
    }

    public int removeQty(int subtraction) {
        qty = subtraction > qty ? 0 : qty - subtraction;

        return qty;
    }

    public double totalPrice() {
        return qty * price;
    }

    public String getId() {
        return id;
    }
}
