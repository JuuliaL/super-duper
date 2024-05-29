/* Create a class for an object that you can find on your table or for something you own - 
For example: Vehicle
Brand
Year
Color
OwnersName

Initialize 3 different objects out of this class, and print it out.

Try to use as many data types as you can (int, String, boolean and so on) */

public class Main {
  public static void main(String[] args) {

    Car car1 = new Car("Toyota", 2020, "Black", false, 20000.0, "John Smith");

    System.out.println("Brand: " + car1.brand + "\nYear: " + car1.year + "\nColor: " + car1.color + "\nIs Automatic: "
        + car1.isAutomatic + "\nPrice: " + car1.price + "\nOwners Name: " + car1.ownersName);

    System.out.println();

    var car2 = new Car("Honda", 2019, "Red", true, 25000.0, "Jane Doe");
    System.out.println("Brand: " + car2.brand + "\nYear: " + car2.year + "\nColor: " + car2.color + "\nIs Automatic: "
        + car2.isAutomatic + "\nPrice: " + car2.price + "\nOwners Name: " + car2.ownersName);

    System.out.println("\nTotal count of cars for sale: " + Car.totalCars);

  }

}

public class Car {

  public static int totalCars = 0;
  public String brand;
  public int year;
  public String color;
  public boolean isAutomatic;
  public double price;
  public String ownersName;

  public Car(String brand, int year, String color, boolean isAutomatic, double price, String ownersName) {
    this.brand = brand;
    this.year = year;
    this.color = color;
    this.isAutomatic = isAutomatic;
    this.price = price;
    this.ownersName = ownersName;
    totalCars++;
  }

}
