/*
Food -> Superclass
Pizza -> Subclass
Burger -> Subclass
*/
import java.util.ArrayList;;

public class Main {
  public static void main(String[] args) {
    System.out.println("This is Restaurant!");

    var menu = new ArrayList<Food>();

    var burger1 = new Burger();
    burger1.price = 5.99f;
    burger1.type = "CheeseBurger";
    burger1.pattyCount = 1;
    menu.add(burger1);

    var burger2 = new Burger();
    burger2.price = 6.99f;
    burger2.pattyCount = 2;
    burger2.type = "DoubleBurger";
    menu.add(burger2);

    var pizza1 = new Pizza();
    pizza1.price = 8.99f;
    pizza1.type = "PepperoniPizza";
    pizza1.addPineapple = true;
    menu.add(pizza1);

    var pizza2 = new Pizza();
    pizza2.price = 9.99f;
    pizza2.type = "CheesePizza";
    pizza2.addPineapple = false;
    menu.add(pizza2);

    for (var food : menu) {
      food.order();

      if (food instanceof Burger) {
        var burger = (Burger) food;
        System.out.println(burger.type + " price: " + burger.price);
        System.out.println("Burger has " + burger.pattyCount + " patty");
      } else if (food instanceof Pizza) {
        var pizza = (Pizza) food;
        if (pizza.addPineapple) {
          System.out.println(pizza.type + " price: " + pizza.price);
          System.out.println("Pizza has Pineapple");
        } else {
          System.out.println(pizza.type + " price: " + pizza.price);
          System.out.println("Pizza has no Pineapple");
        }

      }

    }
  }

}
