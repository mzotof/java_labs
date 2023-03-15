import java.time.LocalDateTime;

public class Order {
    private final int orderNumber;
    private final LocalDateTime orderDate;
    private final Client client;
    private final OnlineStoreProduct[] products;
    private final double total;

    public Order(int orderNumber, Client client, OnlineStoreProduct[] products) {
        this.orderNumber = orderNumber;
        this.orderDate = LocalDateTime.now();
        this.client = client;
        this.products = products;
        this.total = calculateTotal();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Client getClient() {
        return client;
    }

    public OnlineStoreProduct[] getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    private double calculateTotal() {
        double sum = 0;
        for (OnlineStoreProduct product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Date: ").append(orderDate).append("\n");
        sb.append("Client: ").append(client).append("\n");
        sb.append("Products: \n");
        for (OnlineStoreProduct product : products) {
            sb.append("\t").append(product).append("\n");
        }
        sb.append("Total: $").append(total).append("\n");
        return sb.toString();
    }
}
