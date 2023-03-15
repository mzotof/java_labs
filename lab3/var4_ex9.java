public class var4_ex9 {
    public static void main(String[] args) {
        OnlineStoreProduct product1 = new OnlineStoreProduct("Apple", 2);
        OnlineStoreProduct product2 = new OnlineStoreProduct("Onion", 1);

        Administrator administrator = new Administrator();
        administrator.addProduct(product1);
        administrator.addProduct(product2);
        System.out.println("Products list:\n" + administrator.getProductsList());

        Client client1 = new Client("Ivan", "ivan@mail.ru", "Moscow", 20);
        OnlineStoreProduct[] products1 = {
                administrator.getProducts().get(0),
                administrator.getProducts().get(1)
        };
        Order order1 = new Order(1, client1, products1);
        System.out.println(order1);

        administrator.registerSale(order1);

        System.out.println("Ivan's balance after registering sale: " + client1.getBalance());

        Client client2 = new Client("Peter", "peter@mail.ru", "SPB", 0);
        administrator.blacklistClient(client2);

        System.out.println("\nBlacklist:\n" + administrator.getBlacklist());

        OnlineStoreProduct[] products2 = {
                administrator.getProducts().get(0)
        };
        Order order2 = new Order(2, client2, products2);
        System.out.println("\n" + order2);

        System.out.println("Trying to register sale with blacklisted client...");
        administrator.registerSale(order2);

        Client client3 = new Client("Anna", "anna@mail.ru", "Kazan", 4);

        OnlineStoreProduct[] products3 = {
                administrator.getProducts().get(0),
                administrator.getProducts().get(0),
                administrator.getProducts().get(1)
        };
        Order order3 = new Order(3, client3, products3);
        System.out.println("\n" + order3);

        System.out.println("Trying to register sale with client having not enough money for it...");
        administrator.registerSale(order3);
    }
}
