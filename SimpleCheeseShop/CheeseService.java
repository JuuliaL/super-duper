/* CheeseService:
- gives access for the shop owner to add different cheeses
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class CheeseService {
    private static final String FILE_NAME = "cheeses.json";
    private ArrayList<Cheese> cheeses = new ArrayList<Cheese>();
    private static final Gson gson = new Gson();

    public CheeseService() {
        loadCheeses();
    }

    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public void removeCheese(int id) {
        for (var cheese : cheeses) {
            if (cheese.getId() == id) {
                cheeses.remove(cheese);
                return;
            }
        }
    }

    public void updateCheese(int id, int newId, String name, double cost) {
        for (Cheese cheese : cheeses) {
            if (cheese.getId() == id) {
                cheese.setId(newId);
                cheese.setName(name);
                cheese.setCost(cost);
                return;
            }
        }
        System.out.println("Cheese with ID: " + id + " not found.");
    }


    public void showCheeses() {
        for (var cheese : cheeses) {
            System.out.println("Cheese ID: " + cheese.getId() + "\n" + "Cheese: " + cheese.getName() + "\n" + " Price: " + cheese.getCost() + "\n");

        }
        return;
    }

    public void saveCheeses() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(cheeses, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCheeses() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Cheese>>() {
            }.getType();
            cheeses = gson.fromJson(reader, listType);
        } catch (IOException e) {
            cheeses = new ArrayList<>();
        }
    }
}
