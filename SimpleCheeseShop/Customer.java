/*Customer:
- contains money the customer has(100 by default, set in Main)
- contains the items the customer owns
- whenever the customer buys something, money is reduced
- if customer doesn't have any money left, then notify the user about it. */

import java.util.ArrayList;


public class Customer {

    private double money;


    public Customer(double money) {
        this.money = money;
    }


    public void buyCheese(Cheese cheese) {
        money -= cheese.getCost();
    }

    public double getMoney() {
        return money;
    }


    public void setMoney(double money) {
        this.money = money;
    }

    public void buyCheeses(ArrayList<Cheese> cart) {
        for (var cheese : cart) {
            money -= cheese.getCost();
        }
    }
}
