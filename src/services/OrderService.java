package services;

import database.StoreDatabase;
import java.util.Map;
import models.Order;
import models.Product;

public class OrderService {
    private final ProductService product_service;
    private final Map<Integer, Order> orders_DB;

    public OrderService() {
        product_service = new ProductService();
        orders_DB = StoreDatabase.getInstance().getOrders();
    }
    
    public void createOrder(Order order) {

        double total_price = 0;
        
        // Loop through each product and its quantity inside the order
        for(Map.Entry<Product, Integer> entry:order.getProducts().entrySet()) {
            Product curr_Product = product_service.searchById(entry.getKey().getId());

            if(curr_Product == null) {
                System.out.println("product not found");
                return ;
            }

            if(curr_Product.getStock() < entry.getValue()) {
                System.out.println("Not enough stock for: " + curr_Product.getName());
                return ;
            }

            total_price += entry.getValue() * curr_Product.getPrice();
        }

        for(Map.Entry<Product, Integer> entry:order.getProducts().entrySet()) {
            Product product = entry.getKey();
            product.setStock(product.getStock() - entry.getValue());
        }

        order.setTotalPrice(total_price);
        orders_DB.put(order.getId(), order);
    }
}
