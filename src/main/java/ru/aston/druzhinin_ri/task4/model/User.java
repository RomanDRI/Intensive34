package ru.aston.druzhinin_ri.task4.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class User {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private int orderId;
    private Set<Order> order = new HashSet<>();

    public User(String fullName, String phone, String email, int orderId) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.orderId = orderId;
    }


    public User(int id, String fullName, String phone, String email, int orderId) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && orderId == user.orderId && Objects.equals(fullName, user.fullName) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phone, email, orderId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
