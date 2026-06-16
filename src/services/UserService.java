package services;

import database.StoreDatabase;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.User;

public class UserService {
    private final Map<Integer, User> users_DB;

    public UserService() {
        var StoreData_instance = StoreDatabase.getInstance();
        users_DB = StoreData_instance.getUsers();
    }

    public void add(User user) {
        boolean checkEmail = users_DB.values()
        .stream()
        .anyMatch(curr_user -> curr_user.getEmail().equalsIgnoreCase(user.getEmail()));

        if(checkEmail) {
            throw new IllegalArgumentException("Email already exists");
        }

        users_DB.put(user.getId(), user);
    }

    public void remove(int id) {
        if(!users_DB.containsKey(id)) {
            throw new IllegalArgumentException("User with id " + id + " does not exist");
        }

        users_DB.remove(id);
    }

    public User searchByName(String name) {
        return users_DB.values()
        .stream()
        .filter(user -> user.getName().equals(name))
        .findFirst()
        .orElse(null);
    }

    public User searchById(int id) {
        return users_DB.get(id);
    }

    public List<User> filterByAge(int age) {
        return users_DB.values()
        .stream()
        .filter(curr_user -> curr_user.getAge() == age)
        .collect(Collectors.toList());
    }

    public void display() {
        // the System.out::println is using the toString method of the User class to print the user details
        users_DB.values().forEach(System.out::println);
    }
}
