import java.util.ArrayList;
import java.util.Scanner;

public class OnlineFoodOrderingSystem {

    static Scanner sc = new Scanner(System.in);

    static String systemUsername = "customer";
    static String systemPassword = "123";

    static ArrayList<String> cart = new ArrayList<>();
    static ArrayList<Integer> prices = new ArrayList<>();

    static String customerName;
    static String address;
    static String phone;

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("    ONLINE FOOD ORDERING SYSTEM");
        System.out.println("====================================");

        login();

        getCustomerDetails();

        int choice;

        do {

            System.out.println("\n========= FOOD MENU =========");
            System.out.println("1. Chicken Biryani  - Rs.250");
            System.out.println("2. Pizza            - Rs.300");
            System.out.println("3. Burger           - Rs.150");
            System.out.println("4. Shawarma         - Rs.180");
            System.out.println("5. Fried Rice       - Rs.200");
            System.out.println("6. Soft Drink       - Rs.50");
            System.out.println("7. View Cart");
            System.out.println("8. Place Order");
            System.out.println("9. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addToCart("Chicken Biryani",250);
                    break;

                case 2:
                    addToCart("Pizza",300);
                    break;

                case 3:
                    addToCart("Burger",150);
                    break;

                case 4:
                    addToCart("Shawarma",180);
                    break;

                case 5:
                    addToCart("Fried Rice",200);
                    break;

                case 6:
                    addToCart("Soft Drink",50);
                    break;

                case 7:
                    viewCart();
                    break;

                case 8:
                    placeOrder();
                    break;

                case 9:
                    System.out.println("Thank You For Visiting!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 9);
    }

    static void login() {

        System.out.print("Username : ");
        String user = sc.next();

        System.out.print("Password : ");
        String pass = sc.next();

        if(user.equals(systemUsername)
                && pass.equals(systemPassword)) {

            System.out.println("Login Successful");

        } else {

            System.out.println("Invalid Login");
            System.exit(0);
        }
    }

    static void getCustomerDetails() {

        sc.nextLine();

        System.out.print("Enter Customer Name : ");
        customerName = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        phone = sc.nextLine();

        System.out.print("Enter Address : ");
        address = sc.nextLine();
    }

    static void addToCart(String food,int price) {

        cart.add(food);
        prices.add(price);

        System.out.println(food + " Added To Cart");
    }

    static void viewCart() {

        if(cart.isEmpty()) {

            System.out.println("Cart Is Empty");
            return;
        }

        System.out.println("\n======= MY CART =======");

        int total = 0;

        for(int i=0;i<cart.size();i++) {

            System.out.println(
                    (i+1)+". "
                    +cart.get(i)
                    +" - Rs."
                    +prices.get(i));

            total += prices.get(i);
        }

        System.out.println("----------------------");
        System.out.println("Total : Rs." + total);
    }

    static void placeOrder() {

        if(cart.isEmpty()) {

            System.out.println("Cart Is Empty");
            return;
        }

        int total = 0;

        System.out.println("\n======= ORDER SUMMARY =======");

        System.out.println("Customer : " + customerName);
        System.out.println("Phone    : " + phone);
        System.out.println("Address  : " + address);

        System.out.println("\nOrdered Items:");

        for(int i=0;i<cart.size();i++) {

            System.out.println(
                    cart.get(i)
                    +" - Rs."
                    +prices.get(i));

            total += prices.get(i);
        }

        System.out.println("--------------------------");
        System.out.println("Total Bill : Rs." + total);

        System.out.println("\nOrder Placed Successfully");
        System.out.println("Estimated Delivery Time : 30 Minutes");

        cart.clear();
        prices.clear();
    }
}

