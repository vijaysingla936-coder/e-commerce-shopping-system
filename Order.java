public class Order {
    int orderId;
    String customerName;
    double amount;
    String status;

    public Order(int id, String name, double amt) {
        orderId = id;
        customerName = name;
        amount = amt;
        status = "Pending";
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: Rs." + amount);
        System.out.println("Status: " + status);
    }

    public void confirmOrder() {
        status = "Confirmed";
        System.out.println("Order Confirmed");
    }

    public void deliverOrder() {
        status = "Delivered";
        System.out.println("Order Delivered to " + customerName);
    }

    public static void main(String[] args) {
        Order o1 = new Order(1, "Vijay", 1200);
        o1.showOrder();
        o1.confirmOrder();
        o1.deliverOrder();
    }
}
