Main.java

import java.util.Scanner;

public class Main {
    public static Shop shop = new Shop();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the shop!");

        while (true) {
            System.out.println("\nPress 1 to add an item.");
            System.out.println("Press 2 to show the item list.");
            System.out.println("Press 3 to remove an item.");
            System.out.println("Press 4 to add an item to cart.");
            System.out.println("Press 5 to show cart.");
            System.out.println("Press 6 to see total price of the cart.");
            System.out.println("Press any other key to exit.\n");
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                addItem();
            } else if (userInput == 2) {
                showItemList();
            } else if (userInput == 3) {
                removeItem();
            } else if (userInput == 4) {

                addItemToCart();
            } else if (userInput == 5) {
                showCart(shop);
            } else if (userInput == 6) {
                System.out.println("Total price of the cart is: " + shop.checkout());
            } else {
                break;
            }
        }
    }


    public static void addItemToCart() {
        System.out.println("Enter item id you want to add to the cart: ");
        int id = scanner.nextInt();
        shop.addItemToCart(id);
    }

    public static void addItem() {
        System.out.println("Enter item name:");
        String name = scanner.next();
        System.out.println("Enter item cost:");
        double cost = scanner.nextDouble();
        System.out.println("Enter item id:");
        int id = scanner.nextInt();
        Item item = new Item(id, name, cost);
        shop.addItem(item);
    }

    public static void removeItem() {
        System.out.println("Enter item id:");
        int id = scanner.nextInt();
        shop.removeItem(id);
    }

    public static void showItemList() {
        var items = shop.getItems();
        for (var item : items) {
            System.out.println("Item name: " + item.getName());
            System.out.println("Item cost: " + item.getCost());
            System.out.println("Item id: " + item.getId() + "\n");
        }
    }

    public static void showCart(Shop shop) {
        var cartItems = shop.getCart();
        for (var item : cartItems) {
            System.out.println("Item name: " + item.getName());
            System.out.println("Item cost: " + item.getCost());
            System.out.println("Item id: " + item.getId() + "\n");
        }
    }
}

Item.java

public class Item {
    private String name; // item.name = "another name";
    private double cost; //gold pieces
    private int id;


    public Item(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public void setName(String name) {

        // do some logic here
        this.name = name;
        // do some logic here
    }

    public String getName() {
        // check if cashier - then allow to change
        return name;
    }

    public void setCost(double cost) {
        // check if cashier - then allow to change
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

Shop.java


// ItemManager + Shop

import java.util.ArrayList;

public class Shop {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Item> cart = new ArrayList<Item>();


    public ArrayList<Item> getCart() {
        return cart;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        // add to the list
        items.add(item);
    }

    public void removeItem(int id) {
        for (var item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return; // stops the function return for void same as break for a loop
            }
        }
    }

    public void updateItem(int id, String name, int cost) {
        // find item with id
        // update the item w name and cost


        for (var item : items) {
            if (item.getId() == id) {
                item.setName(name);
                item.setCost(cost);
                return;
            }
        }
    }

    public void addItemToCart(int id) {
        // items list, it would contain the amount on available items
        // before adding we will check if item is available
        for (var item : items) {
            if (item.getId() == id) {
                cart.add(item);
                return; // stops the function return for void same as break for a loop
            }
        }

    }

    public int checkout() { // get total cost of cart
        int sum = 0;
        for (var item : cart) {
            sum += item.getCost();

        }
        return sum;
    }

    public void printCartItems() {
        for (var item : cart) {
            System.out.println("Item name: " + item.getName());
            System.out.println("Item cost: " + item.getCost());
            System.out.println("Item id: " + item.getId() + "\n");
        }
    }
}

