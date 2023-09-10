package ru.aston.druzhinin_ri.task4.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



@Getter
@Setter
public class Order {
    private int id;
    private int numberOfOrder;
    private Set<User> user = new HashSet<>();

    public Order(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Order(int id, int numberOfOrder) {
        this.id = id;
        this.numberOfOrder = numberOfOrder;
    }

    public void addUser(User user) {
        this.user.add(user);
        user.getOrder().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && numberOfOrder == order.numberOfOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfOrder);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", numberOfOrder=" + numberOfOrder +
                '}';
    }
}
