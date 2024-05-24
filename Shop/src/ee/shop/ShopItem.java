package ee.shop;
import java.math.BigDecimal;

public class ShopItem {
    private String name;
    private BigDecimal price;
    private static String shopName = "MyShop";

    public ShopItem(String name) {
        this.name = name;
    }

    public ShopItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static String getShopName() {
        return shopName;
    }

    public static void setShopName(String shopName) {
        ShopItem.shopName = shopName;
    }

    @Override
    public String toString() {
        return String.format("\n%s %s %.2f",shopName, name, price);

    }
}
