package ru.aston.druzhinin_ri.task1.order;

import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;


public class OrbitalFlight extends OrderCosmoTicket{
    private BigDecimal bigDecimal;

    public OrbitalFlight(BigDecimal discount, User user, BigDecimal price, int id, BigDecimal bigDecimal) {
        super(discount, user, price, id);
        this.bigDecimal = bigDecimal;
    }

    @Override
    public BigDecimal discount() {
        return super.getDiscount().multiply(bigDecimal);
    }
}
