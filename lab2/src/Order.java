import java.util.List;

public class Order {
    private double totalPrice;
    private List<Product> products;
    /**
     * Данный конструктор принимает
     * следующие параметры:
     * @param cart Корзину покупателя.
     * @param employee Работника. */
    public Order(Cart cart, Employee employee) {this.products = cart.getProducts();
    }
    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
    public List<Product> getProducts() {return products;}
    /**
     * Метод добавления продукта в корзину.
     */
    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }
    /**
     * Метод удаления продукта из корзины.
     */
    public void removeProduct(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}