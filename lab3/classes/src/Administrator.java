import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private List<OnlineStoreProduct> products = null;
    private final List<Client> blacklist;

    public Administrator() {
        products = new ArrayList<>();
        blacklist = new ArrayList<>();
    }

    public void addProduct(OnlineStoreProduct product) {
        products.add(product);
    }

    public List<OnlineStoreProduct> getProducts() {
        return products;
    }

    public void registerSale(Order order) {
        if (blacklist.contains(order.getClient()))
            System.out.println("This client is blacklisted and cannot make purchases.");
        else if (order.getClient().getBalance() < order.getTotal())
            System.out.println("This client cannot make purchases " +
                    "because he does not have enough money on his balance.");
        else
            order.getClient().makeTransaction(-order.getTotal());
    }

    public void blacklistClient(Client client) {
        blacklist.add(client);
    }

    public List<Client> getBlacklist() {
        return blacklist;
    }

    public String getProductsList() {
        StringBuilder sb = new StringBuilder();
        for (OnlineStoreProduct product : products) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}
