public class Payment {
    private double bill;
    /**
     * Данный конструктор принимает
     * лишь один параметр:
     * @param bill Итоговый счёт.
     */
    public Payment(double bill) {this.bill = bill;}
    public double getBill() {
        return bill;
    }
    public void setBill(double price) {
        this.bill = price;
    }
    @Override
    public String toString() {return "The payment price is: " + this.bill;}
    public void paymentDetails(Payment payment) {
        String paymentInfo = payment.toString();
        System.out.println(paymentInfo);
    }
}

