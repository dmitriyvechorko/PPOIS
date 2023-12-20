import java.util.*;

public class Cart{
    private int cartId;
    private List<Product> products;
    /** Данный конструктор принимает
     * лишь один параметр:
     * @param cartId Id корзины.*/
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