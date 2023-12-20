public class Discount{
    //discountAmount
    private double discountPercentage;
    /**
     * Данный конструктор принимает
     * следующие параметры:
     * @param product Прдукт, которому будет присвоена скидка.
     * @param discountPercentage Скидка в процентном эквиваленте.
     */
    public Discount(Product product, double discountPercentage) {this.discountPercentage = discountPercentage;}
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public void applyDiscount(Product product) {
        double price = product.getPrice();
        double discountAmount =  price * (0.01*this.getDiscountPercentage());
        product.setPrice(price-discountAmount);
    }
}