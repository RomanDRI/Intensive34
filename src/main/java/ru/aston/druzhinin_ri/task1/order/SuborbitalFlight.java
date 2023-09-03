package ru.aston.druzhinin_ri.task1.order;

import ru.aston.druzhinin_ri.task1.model.User;
import ru.aston.druzhinin_ri.task2.exception.CustomException;

import java.math.BigDecimal;

public class SuborbitalFlight extends OrderCosmoTicket{
    private BigDecimal bigDecimal;

    public SuborbitalFlight(BigDecimal price, User user, int id, BigDecimal bigDecimal) throws CustomException {
        super(price, user, id);
        this.bigDecimal = bigDecimal;
    }

    @Override
    public BigDecimal discount() {
        return super.getPrice().multiply(bigDecimal);
    }
}
