package services;

import database.StoreDatabase;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.Product;

public class ProductService {
    private final Map<Integer, Product> products_DB;

    public ProductService() {
        var StoreData_instance = StoreDatabase.getInstance();
        products_DB = StoreData_instance.getProducts();
    }

    public void add(Product product) {
        products_DB.put(product.getId(), product);
    }

    public void updateStock(int id, int stock) {
        Product product = products_DB.get(id);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if(stock < 0) {
            System.out.println("error stock cannot be negative");
            return ;
        }

        product.setStock(stock);
        System.out.println("stock updated");
    }

    public void updatePrice(int id, double price) {
        Product product = products_DB.get(id);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if(price == product.getPrice()) {
            System.out.println("Nothing to update");
            return ;
        }

        if(price < 0) {
            System.out.println("error price cannot be negative");
        }

        product.setPrice(price);
        System.out.println("price updated");
    }

    public void delete(int id) {
        products_DB.remove(id);
        System.out.println("product with id: " + id + " deleted");
    }

    public Product searchByName(String name) {
        return products_DB.values()
        .stream()
        .filter(product -> product.getName().equals(name))
        .findFirst()
        .orElse(null);
    }

    public List<Product> searchByCategory(String category) {
        return products_DB.values()
        .stream()
        .filter(product -> product.getCategory().equalsIgnoreCase(category))
        .collect(Collectors.toList());
    }

    public Product searchById(int id) {
        return products_DB.get(id);
    }

    public List<Product> sortByPrice() {
        return products_DB.values()
        .stream()
        .sorted(Comparator.comparing(Product::getPrice))
        .collect(Collectors.toList());
    }
}
