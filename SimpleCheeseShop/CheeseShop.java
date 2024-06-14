/* CheeseShop:
- gives access for the customer to buy different cheeses,
- remove cheese from cart,
- get all the cheeses from the cart or available cheeses in the store*/

import java.util.ArrayList;

public class CheeseShop {

    private ArrayList<Cheese> cart = new ArrayList<Cheese>();

    public void addCheeseToCart(Cheese cheese) {
        cart.add(cheese);
    }

    public void removeCheeseFromCart(int id) {
        for (var cheese : cart) {
            if (cheese.getId() == id) {
                cart.remove(cheese);
                return;
            }
        }
    }

    public ArrayList<Cheese> getCart() {
        return cart;
    }

    public ArrayList<Cheese> getAvailableCheeses(ArrayList<Cheese> cheeses) {
        return cheeses;
    }


    public void checkout(Customer customer) {
        double totalCost = 0;
        for (var cheese : cart) {
            totalCost += cheese.getCost();
        }
        if (customer.getMoney() < totalCost) {
            System.out.println("Not enough money to checkout");
            return;
        }
        customer.buyCheeses(cart);
        System.out.println("You have successfully checked out. The total cost is: " + totalCost);
        cart.clear();
        System.out.println("Your remaining money is: " + customer.getMoney());
    }


}
