import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * OfferSystem.java - E-Commerce Shopping System
 * Author: vijaysingla936-coder
 * Handles Coupons, Discounts, Festival Offers, Loyalty Points
 */

class Coupon {
    String code;
    String description;
    double discountPercent;
    double minOrderValue;
    LocalDate expiryDate;
    boolean isActive;
    int usageCount;
    
    public Coupon(String code, String desc, double discount, double minOrder, LocalDate expiry) {
        this.code = code;
        this.description = desc;
        this.discountPercent = discount;
        this.minOrderValue = minOrder;
        this.expiryDate = expiry;
        this.isActive = true;
        this.usageCount = 0;
    }
    
    public boolean isValid() {
        return isActive && LocalDate.now().isBefore(expiryDate);
    }
}

class LoyaltyProgram {
    String customerId;
    int points;
    String tier;
    
    public LoyaltyProgram(String custId) {
        this.customerId = custId;
        this.points = 0;
        this.tier = "BRONZE";
    }
    
    public void addPoints(double orderAmount) {
        int earned = (int)(orderAmount / 10);
        points += earned;
        updateTier();
        System.out.println("Earned " + earned + " loyalty points. Total: " + points);
    }
    
    private void updateTier() {
        if (points > 1000) tier = "GOLD";
        else if (points > 500) tier = "SILVER";
        else tier = "BRONZE";
        System.out.println("Current Tier: " + tier);
    }
}

public class OfferSystem {
    
    private ArrayList<Coupon> couponList;
    private Scanner sc;
    
    public OfferSystem() {
        couponList = new ArrayList<>();
        sc = new Scanner(System.in);
        initializeDefaultCoupons();
        System.out.println("Offer System Initialized with " + couponList.size() + " offers");
    }
    
    private void initializeDefaultCoupons() {
        couponList.add(new Coupon("WELCOME10", "New User Welcome Offer", 10, 500, LocalDate.now().plusMonths(1)));
        couponList.add(new Coupon("SAVE20", "Flat 20% OFF on Electronics", 20, 1000, LocalDate.now().plusDays(15)));
        couponList.add(new Coupon("DIWALI50", "Diwali Dhamaka Sale 50% OFF", 50, 2000, LocalDate.now().plusDays(10)));
        couponList.add(new Coupon("FREESHIP", "Free Shipping on All Orders", 100, 499, LocalDate.now().plusMonths(2)));
        couponList.add(new Coupon("STUDENT15", "Student Special 15% OFF", 15, 0, LocalDate.now().plusMonths(3)));
        couponList.add(new Coupon("FESTIVAL25", "Festival Season Offer", 25, 1500, LocalDate.now().plusDays(20)));
        couponList.add(new Coupon("LOYAL30", "Loyal Customer 30% OFF", 30, 3000, LocalDate.now().plusMonths(1)));
    }
    
    public void showAllOffers() {
        System.out.println("\n========== AVAILABLE OFFERS ==========");
        System.out.println("Code       | Discount | Min Order | Expiry     | Description");
        System.out.println("----------------------------------------------------------------");
        for (Coupon c : couponList) {
            System.out.printf("%-10s | %-8.0f%% | Rs.%-6.0f | %s | %s\n", 
                c.code, c.discountPercent, c.minOrderValue, c.expiryDate, c.description);
        }
        System.out.println("----------------------------------------------------------------");
    }
    
    public Coupon validateCoupon(String code, double orderAmount) {
        System.out.println("\nValidating coupon: " + code + " for order amount: " + orderAmount);
        for (Coupon c : couponList) {
            if (c.code.equalsIgnoreCase(code)) {
                if (!c.isValid()) {
                    System.out.println("Coupon Expired or Inactive!");
                    return null;
                }
                if (orderAmount < c.minOrderValue) {
                    System.out.println("Minimum order of Rs. " + c.minOrderValue + " required for this coupon!");
                    return null;
                }
                System.out.println("Coupon Valid! " + c.discountPercent + "% discount applicable.");
                c.usageCount++;
                return c;
            }
        }
        System.out.println("Invalid Coupon Code!");
        return null;
    }
    
    public double calculateDiscountedPrice(double originalPrice, Coupon coupon) {
        if (coupon == null) return originalPrice;
        double discountAmount = (originalPrice * coupon.discountPercent) / 100;
        double finalPrice = originalPrice - discountAmount;
        System.out.printf("Original: Rs. %.2f | Discount: Rs. %.2f | Final: Rs. %.2f\n", 
            originalPrice, discountAmount, finalPrice);
        return finalPrice;
    }
    
    public void createCustomCoupon() {
        System.out.println("\n--- CREATE NEW COUPON ---");
        System.out.print("Enter Coupon Code: ");
        String code = sc.nextLine();
        System.out.print("Enter Description: ");
        String desc = sc.nextLine();
        System.out.print("Enter Discount %: ");
        double discount = sc.nextDouble();
        System.out.print("Enter Min Order Value: ");
        double minOrder = sc.nextDouble();
        System.out.print("Enter Validity Days: ");
        int days = sc.nextInt();
        
        Coupon newCoupon = new Coupon(code, desc, discount, minOrder, LocalDate.now().plusDays(days));
        couponList.add(newCoupon);
        System.out.println("New Coupon " + code + " created successfully!");
    }
    
    public void festivalSaleManager() {
        System.out.println("\n========== FESTIVAL SALE MANAGER ==========");
        System.out.println("Upcoming Sales:");
        System.out.println("1. Diwali Sale - 50% OFF - Starting in 5 days");
        System.out.println("2. New Year Sale - 40% OFF - Starting in 45 days");
        System.out.println("3. Summer Sale - 30% OFF - Starting in 90 days");
        System.out.println("4. Student Sale - 25% OFF - Live Now");
        System.out.println("Auto-apply best offer enabled: YES");
        System.out.println("===========================================");
    }
    
    public void buyOneGetOneOffer(String productName) {
        System.out.println("\n--- BOGO OFFER APPLIED ---");
        System.out.println("Product: " + productName);
        System.out.println("Buy 1 Get 1 Free! Second item of equal or lesser value free.");
        System.out.println("Offer valid till stock lasts.");
    }
    
    public void referralProgram() {
        System.out.println("\n========== REFERRAL PROGRAM ==========");
        System.out.println("Refer a friend and earn Rs. 200!");
        System.out.println("Your Referral Code: VIJAY2026");
        System.out.println("Friend gets: Rs. 100 OFF on first order");
        System.out.println("Total Referrals: 12");
        System.out.println("Total Earnings: Rs. 2400");
        System.out.println("======================================");
    }
    
    public void displayOfferAnalytics() {
        System.out.println("\n========== OFFER ANALYTICS ==========");
        for (Coupon c : couponList) {
            System.out.println("Code: " + c.code + " | Used: " + c.usageCount + " times | Active: " + c.isActive);
        }
        System.out.println("Most Popular Coupon: SAVE20 (450 uses)");
        System.out.println("Total Discount Given: Rs. 1,25,000");
        System.out.println("=====================================");
    }
    
    // Main method for testing
    public static void main(String[] args) {
        OfferSystem offerSystem = new OfferSystem();
        offerSystem.showAllOffers();
        
        // Simulate an order
        double orderValue = 5000;
        System.out.println("\nOrder Value: Rs. " + orderValue);
        
        Coupon validCoupon = offerSystem.validateCoupon("SAVE20", orderValue);
        double finalPrice = offerSystem.calculateDiscountedPrice(orderValue, validCoupon);
        
        System.out.println("Final Payable Amount: Rs. " + finalPrice);
        
        LoyaltyProgram loyalty = new LoyaltyProgram("CUST101");
        loyalty.addPoints(finalPrice);
        
        offerSystem.festivalSaleManager();
        offerSystem.referralProgram();
        offerSystem.displayOfferAnalytics();
    }
}
