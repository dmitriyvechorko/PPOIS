public class Discount{
    //discountAmount
    private double discountPercentage;
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