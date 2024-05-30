/*Choose an item of your choosing and create a class.
Define 3 different properties (same as yesterday)
Define a function (action that you can do with this item) which would change one of the properties value*/

public class Main {
  public static void main(String[] args) {
    WaterBottle waterBottle = new WaterBottle(1.5f, "plastic");

    for (int i = 0; i < 8; i++) {
      waterBottle.takeASip();
    }

    System.out.printf("Water litres left in bottle: %.2f%n", waterBottle.getCapacity());
  }
}

public class WaterBottle {
  public float capacity;
  public String material;
  public boolean isEmpty;

  public WaterBottle(float capacity, String material) {
    this.capacity = capacity;
    this.material = material;

  }

  public void takeASip() {
    if (!isEmpty) {
      capacity -= 0.1f;
      if (capacity < 0) {
        capacity = 0;
        isEmpty = true;
      }
    }
  }

  public float getCapacity() {
    return capacity;
  }

  public boolean isEmpty() {
    return isEmpty;
  }
}
