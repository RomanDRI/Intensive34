package ru.aston.druzhinin_ri.task1.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class OrderCosmoTicket implements Discount , Comparable<OrderCosmoTicket>{
    private BigDecimal discount;
    private User user;
    private BigDecimal price;
    private int id;

    @Override
    public int compareTo(OrderCosmoTicket orderCosmoTicket) {
        return user.getSourName().compareTo(orderCosmoTicket.user.getSourName());
    }

    public BigDecimal getPrice() {
        return this.price.multiply(discount());
    }
}
