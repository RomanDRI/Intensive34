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
public abstract class OrderCosmoTicket {
    private User user;
    private BigDecimal price;
    private int id;
}
