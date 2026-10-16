// Simple Customer Class - 1st Sem Level
public class Customer {
    int customerId;
    String customerName;
    String email;
    String phone;
    String address;

    public Customer(int id, String name) {
        customerId = id;
        customerName = name;
        email = "not set";
        phone = "not set";
        address = "not set";
        System.out.println("Customer Created: " + name);
    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println("Email Updated");
    }

    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("Phone Updated");
    }

    public void setAddress(String address) {
        this.address = address;
        System.out.println("Address Updated");
    }

    public void showDetails() {
        System.out.println("---- CUSTOMER DETAILS ----");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("--------------------------");
    }

    public void placeOrder() {
        System.out.println(customerName + " placed an order");
    }

    public void cancelOrder() {
        System.out.println("Order Cancelled by " + customerName);
    }

    public void giveFeedback() {
        System.out.println("Thank you for feedback " + customerName);
    }

    public static void main(String[] args) {
        Customer c1 = new Customer(101, "Vijay");
        c1.setEmail("vijay@gmail.com");
        c1.setPhone("9876543210");
        c1.setAddress("Sirsa, Haryana");
        c1.showDetails();
        c1.placeOrder();
    }
}
