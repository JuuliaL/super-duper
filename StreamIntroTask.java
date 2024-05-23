/*
Medium: Create an integer ArrayList, make sure they divide by 2, skip the first 5, limit to three and print them out from another function.
  */
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    var numbersList = new ArrayList<Integer>();
    fillList(numbersList);
    System.out.println(numbersList);

    numbersList
        .stream()
      // .filter(x -> x % 2 == 0) (list full of even and uneven numbers)
        .skip(5)
        .limit(3)
        .forEach(x -> Print(x));

  }

  public static void Print(Integer num) {
    System.out.println();
    System.out.println(num);
  }

  public static void fillList(ArrayList<Integer> numbersList) {
    Random rand = new Random();
    for (int i = 0; i < 25; i++) {
      int randomNum = rand.nextInt(51); // Generate a random integer
      if (randomNum % 2 == 0) { // list is full of even numbers to start with
        numbersList.add(randomNum); // Add to the list
      }
    }
  }

}
