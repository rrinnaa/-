import java.util.HashMap;
import java.util.Map;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

public class Warehouse {
    private Map<String, Product> productMap;

    public Warehouse() {
        productMap = new HashMap<>();
    }

    public void addProduct(String barcode, Product product) {
        productMap.put(barcode, product);
        System.out.println("Product added: " + product);
    }

    public Product findProduct(String barcode) {
        if (productMap.containsKey(barcode)) {
            return productMap.get(barcode);
        } else {
            System.out.println("Product not found for barcode: " + barcode);
            return null;
        }
    }

    public void removeProduct(String barcode) {
        if (productMap.containsKey(barcode)) {
            Product removedProduct = productMap.remove(barcode);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("No product found with barcode: " + barcode);
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Product product1 = new Product("Milk", 1.99, 100);
        Product product2 = new Product("Bread", 0.99, 200);
        Product product3 = new Product("Butter", 2.49, 150);

        warehouse.addProduct("123456", product1);
        warehouse.addProduct("234567", product2);
        warehouse.addProduct("345678", product3);

        Product foundProduct = warehouse.findProduct("123456");
        System.out.println("Found product: " + foundProduct);

        warehouse.removeProduct("234567");

        warehouse.findProduct("234567");
    }
}