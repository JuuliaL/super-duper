
package ee.shop;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShopService {
public void runTheShop() {
        var shopsItems = new ArrayList<String>();
        shopsItems.add("Glass table");
        shopsItems.add("Wooden table");
        shopsItems.add("Round Table");
        shopsItems.add("Doors");
        shopsItems.add("Trapdoor");
        shopsItems.add("Couch");
        shopsItems.add("Bed");
        shopsItems.add("Sofa");

        List<ShopItem> basket = convertToShopItems(shopsItems);

        //convert this to stream :
        basket.stream().forEach(item -> item.setPrice(new BigDecimal(100)));
        Random rand = new Random();

        basket.stream().forEach(item -> pricefy(item, rand));
        System.out.println(basket);
    }
    private void pricefy(ShopItem item, Random rand) {
        item.setPrice(new BigDecimal(rand.nextInt(51)));
        int rnd = rand.nextInt(100);
        System.out.println("MyShop" + rnd);
        item.setShopName("MyShop" + rnd);
    }

    private List<ShopItem> convertToShopItems(ArrayList<String> shopsItems) {
        return shopsItems.stream().map(x -> new ShopItem(x)).collect(Collectors.toList());
    }

}
