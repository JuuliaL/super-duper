/*Main:
 - User UI
 - accesses CheeseService and CheeseShop to buy or to add different cheeses.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheeseService cheeseService = new CheeseService();
        CheeseShop cheeseShop = new CheeseShop();
        Customer customer = new Customer(100);
        System.out.println("Welcome to the Cheese Shop!");
        System.out.println(Image.getLogo());
        System.out.println("Press '1' to enter as the customer or press '2' to enter as an admin?");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("2")) {
            while (true) {
                System.out.println("Admin view:");
                System.out.println("1. Add cheese");
                System.out.println("2. Remove cheese");
                System.out.println("3. Update cheese");
                System.out.println("4. View cheeses list");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter cheese name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter cheese price: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("That's not a number! Please enter a valid number for the cheese price: ");
                            scanner.next();
                        }
                        double cost = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter cheese ID: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("That's not a number! Please enter a valid number for the cheese ID: ");
                            scanner.next();
                        }
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Cheese cheese = new Cheese(id, name, cost);
                        cheeseService.addCheese(cheese);
                        break;
                    case 2:
                        System.out.println("Enter cheese ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        cheeseService.removeCheese(id);
                        break;
                    case 3:
                        System.out.println("Enter cheese ID you want to update: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new name: ");
                        name = scanner.nextLine();
                        System.out.println("Enter new price: ");
                        cost = scanner.nextDouble();
                        scanner.nextLine();
                        cheeseService.updateCheese(id, newId, name, cost);
                        break;
                    case 4:
                        System.out.println(showCheeses(cheeseService) + "\n");
                        break;
                    case 5:
                        cheeseService.saveCheeses();

                        return;
                }
            }
        } else if (userType.equalsIgnoreCase("1")) {
            while (true) {
                System.out.println("\nCustomer view:");
                System.out.println("Your current balance is: " + String.format("%.2f", customer.getMoney()));

                System.out.println("Available cheeses: ");
                System.out.println(showCheeses(cheeseService) + "\n");
                System.out.println("1. Add cheese to cart");
                System.out.println("2. Remove cheese from cart");
                System.out.println("3. View cart");
                System.out.println("4. Checkout");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter cheese ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Cheese cheese = null;
                        for (Cheese c : cheeseService.getCheeses()) {
                            if (c.getId() == id) {
                                cheese = c;
                                break;
                            }
                        }
                        if (cheese != null) {
                            cheeseShop.addCheeseToCart(cheese);
                        } else {
                            System.out.println("Invalid cheese ID. Please try again.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter cheese ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        cheeseShop.removeCheeseFromCart(id);
                        break;
                    case 3:
                        System.out.println("Cart contains: ");
                        for (Cheese c : cheeseShop.getCart()) {
                            System.out.println(c);
                        }
                        break;
                    case 4:
                        cheeseShop.checkout(customer);
                        break;
                    case 5:
                        cheeseService.saveCheeses();
                        return;
                }
            }
        }
    }

    public static String showCheeses(CheeseService cheeseService) {
        var cheeses = cheeseService.getCheeses();
        StringBuilder cheeseInfo = new StringBuilder();
        for (var cheese : cheeses) {
            cheeseInfo.append("\nCheese ID: ").append(cheese.getId()).append("\n")
                    .append("Name: ").append(cheese.getName()).append("\n")
                    .append("Price: ").append(cheese.getCost()).append("\n");
        }
        return cheeseInfo.toString();
    }
}
