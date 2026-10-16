public class Payment {
    int paymentId;
    String customerName;
    double amount;
    String paymentMethod;
    String status;

    public Payment(int id, String name, double amt) {
        paymentId = id;
        customerName = name;
        amount = amt;
        paymentMethod = "Cash on Delivery";
        status = "Pending";
        System.out.println("Payment Created for " + name);
    }

    public void setPaymentMethod(String method) {
        paymentMethod = method;
        System.out.println("Payment Method: " + method);
    }

    public void showPaymentDetails() {
        System.out.println("---- PAYMENT DETAILS ----");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: Rs." + amount);
        System.out.println("Method: " + paymentMethod);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }

    public void makePayment() {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else {
            status = "Paid";
            System.out.println("Payment Successful");
            System.out.println("Rs." + amount + " Paid by " + customerName);
        }
    }

    public void checkDiscount() {
        if (amount > 2000) {
            double discount = amount * 0.15;
            System.out.println("15% Discount: Rs." + discount);
            System.out.println("Final Amount: Rs." + (amount - discount));
        } else if (amount > 1000) {
            double discount = amount * 0.10;
            System.out.println("10% Discount: Rs." + discount);
            System.out.println("Final Amount: Rs." + (amount - discount));
        } else {
            System.out.println("No Discount - Pay Rs." + amount);
        }
    }

    public void refund() {
        status = "Refunded";
        System.out.println("Payment Refunded to " + customerName);
    }

    public static void main(String[] args) {
        Payment p1 = new Payment(1, "Vijay", 1500);
        p1.setPaymentMethod("UPI");
        p1.showPaymentDetails();
        p1.checkDiscount();
        p1.makePayment();
    }
}
