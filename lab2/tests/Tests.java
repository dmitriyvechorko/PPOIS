import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class Tests {
    private Product coke, chicken, potato, cookies, carrot;
    private Inventory inventory;
    private Cart cart1, cart2;
    private Order order1, order2;
    private Discount discount;
    private Employee employee2;
    private Payment payment;

    @Before
    public void setUp() {
        this.employee2 = new Employee("Kate", 2, 25, 870);
        inventory = new Inventory();
        coke = new Product("Кола", 1.2, "Напитки");
        potato = new Product("Картошка", 4, "Овощи");
        chicken = new Product("Курица", 6, "Мясная продукция");
        cookies = new Product("Печенье", 2.70, "Печенье");
        carrot = new Product("Вода", 1.70, "Напитки");
        inventory.addProduct(coke, 10);
        inventory.addProduct(potato, 5);
        inventory.addProduct(chicken, 7);
        inventory.addProduct(cookies, 4);
        this.cart1 = new Cart(13);
        this.cart2 = new Cart(24);
        cart1.addProduct(coke);
        cart1.addProduct(potato);
        cart2.addProduct(chicken);
        cart2.addProduct(cookies);
        this.order1 = new Order(cart1, employee2);
        this.order2 = new Order(cart2, employee2);
        order1.setProducts(cart1.getProducts());
        order2.setProducts(cart2.getProducts());
        this.discount = new Discount(coke, 30);
        this.payment = new Payment(40);
    }
    @Test
    public void testProductSetName() {
        String newName = "Морковь";
        carrot.setName(newName);
        assertEquals(newName, carrot.getName());
    }
    @Test
    public void testProductSetCategory() {
        String newCategory = "Сухие изделия";
        cookies.setCategory(newCategory);
        assertEquals(newCategory, cookies.getCategory());
    }
    @Test
    public void testIRemoveProduct() {
        inventory.removeProduct(coke, 9);
        inventory.removeProduct(cookies, 7);
        assertEquals(1, inventory.getProductQuantity(coke));
        assertEquals(4, inventory.getProductQuantity(cookies));
    }
    @Test
    public void testCartAddRemoveProduct() {
        this.cart1.removeProduct(coke);
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(potato);
        assertEquals(expectedProducts, this.cart1.getProducts());
    }

    @Test
    public void testSetProducts() {
        List<Product> newProducts = new ArrayList<>();
        newProducts.add(new Product("Маффин", 13, "Выпечка"));
        this.order1.setProducts(newProducts);
        assertEquals(newProducts, this.order1.getProducts());
    }
    @Test
    public void testSetTotalPrice() {
        double newTotalPrice = 40.0;
        this.order1.setTotalPrice(newTotalPrice);
        assertEquals(newTotalPrice, this.order1.getTotalPrice(), 0.0001);
    }
    @Test
    public void testOrderAddProduct() {
        Product product = new Product("Test Product 3", 30.0, "k");
        this.order2.addProduct(product);
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(chicken);
        expectedProducts.add(cookies);
        expectedProducts.add(product);
        assertEquals(expectedProducts, this.order2.getProducts());
    }
    @Test
    public void testOrderRemoveProduct() {
        this.order2.removeProduct(chicken);
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(cookies);
        assertEquals(expectedProducts, this.order2.getProducts());
    }
    @Test
    public void testDiscount() {
        this.order2.removeProduct(chicken);
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(cookies);
        assertEquals(expectedProducts, this.order2.getProducts());
    }
    @Test
    public void testApplyDiscountAmount() {
        Product product = new Product("Test Product", 10.0, "l");
        double expectedPrice = 6.0;
        discount.setDiscountPercentage(40);
        discount.applyDiscount(product);
        assertEquals(expectedPrice, product.getPrice(), 0.0001);
    }
    @Test
    public void testSetName() {
        String newName = "Simon";
        this.employee2.setName(newName);
        assertEquals(newName, this.employee2.getName());
    }
    @Test
    public void testSetSalary() {
        double newSalary = 1040;
        this.employee2.setSalary(newSalary);
        assertEquals(newSalary, this.employee2.getSalary(), 0.0001);
    }
    @Test
    public void testDisplayPersonInfo() {
        Person steve = new Person("Steve", 28);
        steve.setName("David");
        steve.setAge(28);
        String name = "David";
        int age = 28;
        assertEquals(name, steve.getName());
        assertEquals(age, steve.getAge());
    }
    @Test
    public void testDisplayEmployeeInfo() {
        String name = "Nick";
        int employeeId = 3;
        int age = 31;
        double salary = 1020;
        Employee employee3 = new Employee("Nick", 3, 31, 1020);
        assertEquals(name, employee3.getName());
        assertEquals(employeeId, employee3.getEmployeeId());
        assertEquals(age, employee3.getAge());
        assertEquals(salary, employee3.getSalary(), 0.0001);
    }
    @Test
    public void testEmployeeId() {
        int newEmployeeId = 5;
        this.employee2.setEmployeeId(newEmployeeId);
        assertEquals(newEmployeeId, this.employee2.getEmployeeId(), 0.001);
    }
    @Test
    public void displayEmployeeInfo() {
        employee2.displayEmployeeInfo(employee2);
        String expected = "Name: Kate, EmployeeId: 2, Age: 25, Salary: 870.0";
        String result = employee2.toString();
        assertEquals(expected, result);
      }
    @Test
    public void testSetBill() {
        double newBill = 2000.0;
        this.payment.setBill(newBill);
        assertEquals(newBill, this.payment.getBill(), 0.001);
    }
    @Test
    public void paymentDetails() {
        payment.paymentDetails(payment);
        String expected = "The payment price is: 40.0";
        String result = payment.toString();
        assertEquals(expected, result);
    }
}
