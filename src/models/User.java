package models;

public class User {
    // final means that the value of this variable cannot be changed after it is initialized
    private final int id;
    private String name;
    private String email;
    private int age;
    private ROLE role;

    public User(int id, String name, String email, int age, ROLE role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public ROLE getRole() {
        return role;
    }

    public void setName(String name) {
        if(name.strip().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if(email.strip().equals("")) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        return user.id == id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}