package ru.aston.druzhinin_ri.task1.order;

import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;

public class OrbitalFlight extends OrderCosmoTicket{
    public OrbitalFlight(User user, BigDecimal price, int id) {
        super(user, price, id);
    }
}
