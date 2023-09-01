package ru.aston.druzhinin_ri.task1.order;

import lombok.*;
import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public abstract class OrderCosmoTicket implements Discount , Comparable<OrderCosmoTicket>{
    private BigDecimal discount;
    private User user;
    private int id;

    @Override
    public int compareTo(OrderCosmoTicket orderCosmoTicket) {
        return user.getSourName().compareTo(orderCosmoTicket.user.getSourName());
    }

    public BigDecimal getPrice() {
        return this.discount.multiply(discount());
    }
}
