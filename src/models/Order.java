package models;

import java.util.Map;

public class Order {
    private final int id;
    private User user;
    private Map<Product, Integer> products;
    private double totalPrice;
    private STATUS status;

    public Order(int id, User user, Map<Product, Integer> products, double totalPrice, STATUS status) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }


    // override equals and hashcode when the object will be used as a map key or stored in a Set/List where you need to search/remove by value
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Order order = (Order) obj;

        return order.id == id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }
}
