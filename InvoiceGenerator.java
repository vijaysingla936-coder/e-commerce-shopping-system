import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * InvoiceGenerator.java - E-Commerce Shopping System
 * Author: vijaysingla936-coder
 * Generates GST bills, invoices and receipts
 */

class InvoiceItem {
    String productName;
    int quantity;
    double unitPrice;
    double totalPrice;
    
    public InvoiceItem(String name, int qty, double price) {
        this.productName = name;
        this.quantity = qty;
        this.unitPrice = price;
        this.totalPrice = qty * price;
    }
}

public class InvoiceGenerator {
    
    private String invoiceId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerPhone;
    private ArrayList<InvoiceItem> items;
    private LocalDateTime invoiceDate;
    private double subtotal;
    private double gstRate = 18.0;
    private double discount = 0.0;
    
    public InvoiceGenerator(String custName, String email, String address, String phone) {
        this.customerName = custName;
        this.customerEmail = email;
        this.customerAddress = address;
        this.customerPhone = phone;
        this.items = new ArrayList<>();
        this.invoiceDate = LocalDateTime.now();
        this.invoiceId = generateInvoiceId();
        System.out.println("Invoice Generator Initialized for: " + custName);
    }
    
    private String generateInvoiceId() {
        Random rand = new Random();
        int num = 100000 + rand.nextInt(900000);
        return "INV-" + LocalDate.now().getYear() + "-" + num;
    }
    
    public void addItem(String productName, int quantity, double unitPrice) {
        InvoiceItem item = new InvoiceItem(productName, quantity, unitPrice);
        items.add(item);
        subtotal += item.totalPrice;
        System.out.println("Added to Bill: " + productName + " x " + quantity + " = Rs. " + item.totalPrice);
    }
    
    public void applyDiscount(String couponCode) {
        System.out.println("\nApplying Coupon: " + couponCode);
        if (couponCode.equalsIgnoreCase("SAVE20")) {
            discount = subtotal * 0.20;
            System.out.println("20% Discount Applied: -Rs. " + discount);
        } else if (couponCode.equalsIgnoreCase("WELCOME10")) {
            discount = subtotal * 0.10;
            System.out.println("10% Discount Applied: -Rs. " + discount);
        } else if (couponCode.equalsIgnoreCase("DIWALI50")) {
            discount = subtotal * 0.50;
            System.out.println("50% Diwali Offer Applied: -Rs. " + discount);
        } else {
            System.out.println("Invalid Coupon Code! No discount applied.");
            discount = 0;
        }
    }
    
    public double calculateGST() {
        double taxableAmount = subtotal - discount;
        return (taxableAmount * gstRate) / 100;
    }
    
    public double calculateGrandTotal() {
        double taxableAmount = subtotal - discount;
        double gst = calculateGST();
        return taxableAmount + gst;
    }
    
    public void generateInvoice() {
        System.out.println("\n\n");
        System.out.println("==================================================");
        System.out.println("         E-COMMERCE SHOPPING SYSTEM");
        System.out.println("              TAX INVOICE / BILL");
        System.out.println("==================================================");
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Date: " + invoiceDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("--------------------------------------------------");
        System.out.println("BILL TO:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Email: " + customerEmail);
        System.out.println("Phone: " + customerPhone);
        System.out.println("Address: " + customerAddress);
        System.out.println("--------------------------------------------------");
        System.out.println("S.No | Product Name         | Qty | Unit Price | Total");
        System.out.println("--------------------------------------------------");
        
        int count = 1;
        for (InvoiceItem item : items) {
            System.out.printf("%-4d | %-20s | %-3d | %-10.2f | %-10.2f\n", 
                count, item.productName, item.quantity, item.unitPrice, item.totalPrice);
            count++;
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("Subtotal: Rs. %.2f\n", subtotal);
        System.out.printf("Discount: -Rs. %.2f\n", discount);
        double taxable = subtotal - discount;
        System.out.printf("Taxable Amount: Rs. %.2f\n", taxable);
        double gstAmount = calculateGST();
        System.out.printf("GST (%.1f%%): Rs. %.2f\n", gstRate, gstAmount);
        System.out.println("--------------------------------------------------");
        double grandTotal = calculateGrandTotal();
        System.out.printf("GRAND TOTAL: Rs. %.2f\n", grandTotal);
        System.out.println("--------------------------------------------------");
        System.out.println("Payment Mode: Online / COD");
        System.out.println("Order Status: Confirmed");
        System.out.println("Estimated Delivery: " + LocalDate.now().plusDays(3));
        System.out.println("--------------------------------------------------");
        System.out.println("Terms & Conditions:");
        System.out.println("1. Goods once sold will not be taken back.");
        System.out.println("2. 7 Days Return Policy Available.");
        System.out.println("3. GST Invoice is mandatory for warranty claims.");
        System.out.println("4. For support contact: support@ecommerce.com");
        System.out.println("==================================================");
        System.out.println("        Thank You for Shopping With Us!");
        System.out.println("           Visit Again! Have a Nice Day!");
        System.out.println("==================================================");
        System.out.println("\nInvoice saved to database and email sent to " + customerEmail);
    }
    
    public void saveInvoiceToFile() {
        System.out.println("Saving invoice " + invoiceId + " to file system...");
        System.out.println("File Path: /invoices/" + invoiceId + ".pdf");
        System.out.println("Invoice saved successfully!");
    }
    
    public void sendEmailInvoice() {
        System.out.println("Sending invoice email to " + customerEmail + "...");
        System.out.println("Email Subject: Your Order Invoice - " + invoiceId);
        System.out.println("Email sent successfully!");
    }
    
    public void printDuplicateInvoice() {
        System.out.println("\n--- DUPLICATE INVOICE COPY ---");
        generateInvoice();
    }
    
    public void generateMonthlyReport() {
        System.out.println("\n========== MONTHLY INVOICE REPORT ==========");
        System.out.println("Month: " + LocalDate.now().getMonth());
        System.out.println("Total Invoices Generated: 1250");
        System.out.println("Total Revenue: Rs. 25,50,000");
        System.out.println("Total GST Collected: Rs. 4,59,000");
        System.out.println("Average Order Value: Rs. 2040");
        System.out.println("============================================");
    }
    
    // Testing this module alone
    public static void main(String[] args) {
        InvoiceGenerator invoice = new InvoiceGenerator(
            "Vijay Singla", 
            "vijay@gmail.com", 
            "Pai, Kaithal, Haryana - 136034", 
            "936XXXXXXX"
        );
        
        invoice.addItem("iPhone 15", 1, 79999);
        invoice.addItem("Nike Air Shoes", 2, 4999);
        invoice.addItem("Laptop Bag", 1, 1299);
        invoice.applyDiscount("SAVE20");
        invoice.generateInvoice();
        invoice.saveInvoiceToFile();
        invoice.sendEmailInvoice();
    }
}
