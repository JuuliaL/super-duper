import java.util.List;

public class Cart {
    private List<Cheese> cheeses;

    public Cart(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart contents:\n");
        for (Cheese cheese : this.cheeses) {
            sb.append("Cheese ID: ").append(cheese.getId()).append("\n")
                    .append("Name: ").append(cheese.getName()).append("\n")
                    .append("Cost: ").append(cheese.getCost()).append("\n\n");
        }
        return sb.toString();
    }
}