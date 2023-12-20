import java.util.*;

public class Cart{
    private int cartId;
    protected List<Product> products;
    public Cart(int cartId) {
        this.cartId = cartId;
        this.products = new ArrayList<>();
    }
    public int getCartId() {return cartId;}
    public List<Product> getProducts() {
        return this.products;
    }
    public void addProduct(Product product) {this.products.add(product);}
    public void removeProduct(Product product) {this.products.remove(product);}
}