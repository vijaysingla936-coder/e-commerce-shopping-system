// Simple Cart System - 1st Sem Level
public class Cart {
    
    // Variables
    int cartId;
    String customerName;
    String productName;
    double productPrice;
    int quantity;
    double totalPrice;

    // Constructor
    public Cart(int id, String customer) {
        cartId = id;
        customerName = customer;
        productName = "No Product";
        productPrice = 0;
        quantity = 0;
        totalPrice = 0;
        System.out.println("Cart Created for " + customerName);
    }

    // Add product
    public void addProduct(String name, double price, int qty) {
        productName = name;
        productPrice = price;
        quantity = qty;
        totalPrice = price * qty;
        System.out.println("Product Added: " + name);
    }

    // Show cart details
    public void showCart() {
        System.out.println("------ CART DETAILS ------");
        System.out.println("Cart ID: " + cartId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + productPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("--------------------------");
    }

    // Calculate total
    public void calculateTotal() {
        totalPrice = productPrice * quantity;
        System.out.println("Total Amount is: " + totalPrice);
    }

    // Apply discount
    public void applyDiscount() {
        double discount = 0;
        if (totalPrice > 1000) {
            discount = totalPrice * 0.10;
            System.out.println("10% Discount Applied");
        } else if (totalPrice > 500) {
            discount = totalPrice * 0.05;
            System.out.println("5% Discount Applied");
        } else {
            System.out.println("No Discount");
        }
        double finalPrice = totalPrice - discount;
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }

    // Clear cart
    public void clearCart() {
        productName = "No Product";
        productPrice = 0;
        quantity = 0;
        totalPrice = 0;
        System.out.println("Cart is Cleared");
    }

    // Checkout
    public void checkout() {
        System.out.println("Checkout Done");
        System.out.println("Thank you " + customerName);
        System.out.println("Please Pay Rs: " + totalPrice);
    }

    // Main method for testing
    public static void main(String[] args) {
        Cart myCart = new Cart(1, "Vijay");
        myCart.addProduct("Laptop Bag", 800, 2);
        myCart.showCart();
        myCart.calculateTotal();
        myCart.applyDiscount();
        myCart.checkout();
    }
}
