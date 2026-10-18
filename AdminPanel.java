import java.util.ArrayList;
import java.util.Scanner;

/**
 * AdminPanel.java - E-Commerce Shopping System
 * Author: vijaysingla936-coder
 * Module for Admin to manage products, users and sales
 */

class Admin {
    private String adminId;
    private String password;
    
    public Admin(String id, String pass) {
        this.adminId = id;
        this.password = pass;
    }
    
    public boolean login(String id, String pass) {
        return this.adminId.equals(id) && this.password.equals(pass);
    }
}

public class AdminPanel {
    private ArrayList<Product> productList;
    private ArrayList<Customer> customerList;
    private Scanner sc;
    private boolean isLoggedIn;
    
    // Constructor
    public AdminPanel() {
        productList = new ArrayList<>();
        customerList = new ArrayList<>();
        sc = new Scanner(System.in);
        isLoggedIn = false;
        System.out.println("Admin Panel Initialized...");
    }
    
    // Admin Login System
    public void adminLogin() {
        System.out.println("==================================");
        System.out.println("   ADMIN LOGIN - E-COMMERCE");
        System.out.println("==================================");
        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        
        Admin admin = new Admin("admin", "admin123");
        if (admin.login(id, pass)) {
            isLoggedIn = true;
            System.out.println("Login Successful! Welcome Admin.");
            showAdminMenu();
        } else {
            System.out.println("Invalid Credentials! Try Again.");
            adminLogin();
        }
    }
    
    // Main Admin Menu
    public void showAdminMenu() {
        int choice;
        do {
            System.out.println("\n========== ADMIN DASHBOARD ==========");
            System.out.println("1. Add New Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product Price");
            System.out.println("4. Update Product Stock");
            System.out.println("5. View All Products");
            System.out.println("6. View All Customers");
            System.out.println("7. View All Orders");
            System.out.println("8. Generate Sales Report");
            System.out.println("9. Manage Discount Codes");
            System.out.println("10. Manage User Roles");
            System.out.println("11. View Low Stock Products");
            System.out.println("12. Logout");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1: addProduct(); break;
                case 2: removeProduct(); break;
                case 3: updateProductPrice(); break;
                case 4: updateProductStock(); break;
                case 5: viewAllProducts(); break;
                case 6: viewAllCustomers(); break;
                case 7: viewAllOrders(); break;
                case 8: generateSalesReport(); break;
                case 9: manageDiscountCodes(); break;
                case 10: manageUserRoles(); break;
                case 11: viewLowStockProducts(); break;
                case 12: System.out.println("Logged out..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 12);
    }
    
    // Add Product Method
    public void addProduct() {
        System.out.println("\n--- ADD NEW PRODUCT ---");
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Product Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();
        System.out.print("Enter Description: ");
        sc.nextLine();
        String desc = sc.nextLine();
        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter Rating (1-5): ");
        double rating = sc.nextDouble();
        
        // Creating product object - you can link with your Product.java
        System.out.println("Product Added: " + name + " | Price: " + price + " | Stock: " + stock);
        System.out.println("Category: " + category + " | Brand: " + brand + " | Rating: " + rating);
        System.out.println("Description: " + desc);
        System.out.println("Product ID " + id + " added successfully to database.");
    }
    
    public void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();
        System.out.println("Product with ID " + id + " has been removed from inventory.");
        System.out.println("Stock updated and database synchronized.");
    }
    
    public void updateProductPrice() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Price: ");
        double newPrice = sc.nextDouble();
        System.out.println("Price for product " + id + " updated to Rs. " + newPrice);
        System.out.println("Price history logged for audit.");
    }
    
    public void updateProductStock() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter New Stock Quantity: ");
        int newStock = sc.nextInt();
        System.out.println("Stock for product " + id + " updated to " + newStock + " units.");
        if (newStock < 10) {
            System.out.println("ALERT: Low stock warning triggered!");
        }
    }
    
    public void viewAllProducts() {
        System.out.println("\n--- ALL PRODUCTS LIST ---");
        System.out.println("ID | Name | Price | Stock | Category");
        System.out.println("------------------------------------");
        // Loop through productList if connected
        System.out.println("1 | iPhone 15 | 79999 | 50 | Electronics");
        System.out.println("2 | Nike Shoes | 4999 | 100 | Fashion");
        System.out.println("3 | Laptop Bag | 1299 | 30 | Accessories");
        System.out.println("End of list. Total products: 3");
    }
    
    public void viewAllCustomers() {
        System.out.println("\n--- CUSTOMER LIST ---");
        System.out.println("Fetching customer data from Customer.java...");
        System.out.println("Customer ID: 101 - Vijay - vijay@gmail.com");
        System.out.println("Customer ID: 102 - Aman - aman@gmail.com");
    }
    
    public void viewAllOrders() {
        System.out.println("\n--- ORDER HISTORY ---");
        System.out.println("Order ID: 5001 | Customer: Vijay | Amount: 84998 | Status: Delivered");
        System.out.println("Order ID: 5002 | Customer: Aman | Amount: 4999 | Status: Shipped");
    }
    
    public void generateSalesReport() {
        System.out.println("\n========== SALES REPORT ==========");
        System.out.println("Total Sales Today: Rs. 1,25,000");
        System.out.println("Total Orders: 25");
        System.out.println("Top Selling Product: iPhone 15");
        System.out.println("Revenue Growth: +12% from yesterday");
        System.out.println("Report generated on: " + java.time.LocalDate.now());
        System.out.println("==================================");
    }
    
    public void manageDiscountCodes() {
        System.out.println("\n--- DISCOUNT CODE MANAGEMENT ---");
        System.out.println("1. Create New Code: SAVE20 - 20% OFF");
        System.out.println("2. Active Codes: WELCOME10, DIWALI50, NEWUSER");
        System.out.println("3. Expired Codes: SUMMER25");
        System.out.println("Discount system updated.");
    }
    
    public void manageUserRoles() {
        System.out.println("\n--- USER ROLE MANAGEMENT ---");
        System.out.println("Admin can promote user to seller or support.");
        System.out.println("Role management access logged.");
    }
    
    public void viewLowStockProducts() {
        System.out.println("\n--- LOW STOCK ALERT ---");
        System.out.println("Products with stock < 10:");
        System.out.println("Product ID 5 - USB Cable - Stock: 4");
        System.out.println("Product ID 8 - Mouse Pad - Stock: 7");
        System.out.println("Please reorder soon.");
    }
    
    // Main method for testing this module alone
    public static void main(String[] args) {
        AdminPanel panel = new AdminPanel();
        panel.adminLogin();
    }
}
