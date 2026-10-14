import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Products list
        Product p1 = new Product(1, "T-Shirt", 499, 10);
        Product p2 = new Product(2, "Jeans", 1299, 5);
        Product p3 = new Product(3, "Shoes", 1999, 8);

        System.out.println("Welcome to Vijay's E-Commerce Store!");
        System.out.println("Available Products:");
        p1.display();
        p2.display();
        p3.display();

        double total = 0;
        System.out.print("\nEnter Product ID to buy (1-3): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            total = p1.getPrice();
            System.out.println("You added " + p1.getName());
        } else if (choice == 2) {
            total = p2.getPrice();
            System.out.println("You added " + p2.getName());
        } else if (choice == 3) {
            total = p3.getPrice();
            System.out.println("You added " + p3.getName());
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Total Bill: Rs." + total);
        System.out.println("Order Placed Successfully! Thank you!");
        sc.close();
    }
}
