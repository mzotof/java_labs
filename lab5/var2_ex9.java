import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
class Product {
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private int shelfLife;
    private int quantity;

    public Product(int id, String name, String upc, String manufacturer, double price, int shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                ", quantity=" + quantity +
                '}';
    }
}
class ProductNotFoundException extends Exception {
    private final String message;
    public String getMessage() {
        return message;
    }
    public ProductNotFoundException(String[] param_names, String[] param_values){
        super();
        StringBuilder sb = new StringBuilder("Продукты с ");
        for (int i = 0; i < param_names.length; i++)
            sb.append(param_names[i]).append(" '").append(param_values[i]).append("' и ");
        sb.delete(sb.length() - 3, sb.length()).append(" не найдены");
        message = sb.toString();
    }
}
public class var2_ex9 {
    private static List<Product> getProductsByName(Product[] products, String name) throws ProductNotFoundException {
        List<Product> res = new ArrayList<>();
        for (Product product : products)
            if (product.getName().equals(name))
                res.add(product);
        if (res.size() == 0)
            throw new ProductNotFoundException(new String[]{"именем"}, new String[]{name});
        return res;
    }
    private static List<Product> getProductsByNameAndPrice(Product[] products, String name, double price) throws ProductNotFoundException {
        List<Product> res = new ArrayList<>();
        for (Product product : products)
            if (product.getName().equals(name) && product.getPrice() <= price)
                res.add(product);
        if (res.size() == 0)
            throw new ProductNotFoundException(new String[]{"именем", "ценой <="}, new String[]{name, Double.toString(price)});
        return res;
    }
    private static List<Product> getProductsByShelfLife(Product[] products, int shelfLife) throws ProductNotFoundException {
        List<Product> res = new ArrayList<>();
        for (Product product : products)
            if (product.getShelfLife() <= shelfLife)
                res.add(product);
        if (res.size() == 0)
            throw new ProductNotFoundException(new String[]{"сроком годности <="}, new String[]{Integer.toString(shelfLife)});
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Product[] products = {
                new Product(1, "Продукт 1", "123456789", "Производитель 1", 10.99, 30, 50),
                new Product(2, "Продукт 2", "987654321", "Производитель 2", 5.99, 60, 100),
                new Product(3, "Продукт 3", "02468", "Производитель 3", 20.99, 90, 20),
                new Product(2, "Продукт 2", "13579", "Производитель 4", 6.99, 60, 2000)
        };
        System.out.print("Введите имя продукта: ");
        String name = in.nextLine();
        try {
            List<Product> productsByName = getProductsByName(products, name);
            System.out.println("\nСписок продкутов с именем '" + name + "':");
            for (Product product : productsByName)
                System.out.println(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nВведите цену продукта: ");
        double price;
        try {
            price = in.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число типа double");
            return;
        }
        try {
            List<Product> productsByNameAndPrice = getProductsByNameAndPrice(products, name, price);
            System.out.println("\nСписок продкутов с именем '" + name + "' и ценой <= " + price + ":");
            for (Product product : productsByNameAndPrice)
                System.out.println(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nВведите срок годности продукта: ");
        int shelfLife;
        try {
            shelfLife = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число типа int");
            return;
        }
        try {
            List<Product> productsByShelfLife = getProductsByShelfLife(products, shelfLife);
            System.out.println("\nСписок продкутов со сроком годности <= " + shelfLife + ":");
            for (Product product : productsByShelfLife)
                System.out.println(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
