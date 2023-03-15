import java.util.Scanner;

public class var2_ex9 {
    private static void getProductsByName(Product[] products, String name) {
        System.out.println("\nList of products for " + name + ":");
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }
    }
    private static void getProductsByNameAndPrice(Product[] products, String name, double price) {
        System.out.println("\nList of products for " + name + " with price <= " + Double.toString(price) + ":");
        for (Product product : products) {
            if (product.getName().equals(name) && product.getPrice() <= price) {
                System.out.println(product);
            }
        }
    }
    private static void getProductsByShelfLife(Product[] products, int shelfLife) {
        System.out.println("\nList of products for with shelf life <= " + Integer.toString(shelfLife) + ":");
        for (Product product : products) {
            if (product.getShelfLife() <= shelfLife) {
                System.out.println(product);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Product[] products = {
                new Product(1, "Product 1", "123456789", "Manufacturer 1", 10.99, 30, 50),
                new Product(2, "Product 2", "987654321", "Manufacturer 2", 5.99, 60, 100),
                new Product(3, "Product 3", "02468", "Manufacturer 3", 20.99, 90, 20),
                new Product(2, "Product 2", "13579", "Manufacturer 4", 6.99, 60, 2000)
        };
        System.out.println("Enter product's name:");
        String name = in.nextLine();
        getProductsByName(products, name);

        System.out.print("\nEnter product's price: ");
        double price = in.nextDouble();
        getProductsByNameAndPrice(products, name, price);

        System.out.print("\nEnter product's self life: ");
        int shelfLife = in.nextInt();
        getProductsByShelfLife(products, shelfLife);

//        Input:
//        Product 2
//        6
//        60
    }
}
