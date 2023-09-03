package ru.aston.druzhinin_ri.task1.order;

import lombok.Data;
import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;



@Data

public abstract class OrderCosmoTicket implements Discount , Comparable<OrderCosmoTicket> {
    private BigDecimal price;
    private User user;
    private int id;

    public OrderCosmoTicket(BigDecimal price, User user, int id) throws CustomException {
        setPrice(price);
        this.user = user;
        this.id = id;
    }

    @Override
    public int compareTo(OrderCosmoTicket orderCosmoTicket) {
        return user.getSourName().compareTo(orderCosmoTicket.user.getSourName());
    }
    public BigDecimal getPriceDiscount() {
        return this.price.multiply(discount());
    }

    public void setPrice(BigDecimal price) throws CustomException {
        if(price.compareTo(new BigDecimal(0))<=0) throw new CustomException ("Цена должна быть больше нуля. Code: CustomException");
        else this.price = price;
    }
}
