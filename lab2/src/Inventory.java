import java.util.HashMap;
import java.util.Map;
public class Inventory {
    protected Map<Product, Integer> stock;
    public Inventory() {this.stock = new HashMap<>();}
    public void addProduct(Product product, int quantity) {
        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            stock.put(product, currentQuantity + quantity);
        } else {
            stock.put(product, quantity);
        }
    }
    public void removeProduct(Product product, int quantity) {
        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            if (currentQuantity >= quantity) {
                stock.put(product, currentQuantity - quantity);
            } else {
                System.out.println("Error: Not enough " + product + " in stock.");
            }
        } else {
            System.out.println("Error: " + product + " not found in stock.");
        }
    }
    public int getProductQuantity(Product product) {
        if (stock.containsKey(product)) {
            return stock.get(product);
        } else {
            return 0;
        }
    }
}