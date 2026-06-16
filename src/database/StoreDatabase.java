package database;

import java.util.HashMap;
import java.util.Map;

import models.Order;
import models.Product;
import models.User;

public class StoreDatabase {
    private static StoreDatabase instance;

    private Map<Integer, User>users;
    private Map<Integer, Order>orders;
    private Map<Integer, Product>products;

    private StoreDatabase() {
        users = new HashMap<>();
        orders = new HashMap<>();
        products = new HashMap<>();
    }

    public static StoreDatabase getInstance() {
        if(instance == null) {
            instance = new StoreDatabase();
        }

        return instance;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }


    public Map<Integer, Order> getOrders() {
        return orders;
    }


    public Map<Integer, Product> getProducts() {
        return products;
    }
}
