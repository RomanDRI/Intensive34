package ru.aston.druzhinin_ri.task1.order;

import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;

public class SuborbitalFlight extends OrderCosmoTicket{
    public SuborbitalFlight(User user, BigDecimal price, int id) {
        super(user, price, id);
    }
}
