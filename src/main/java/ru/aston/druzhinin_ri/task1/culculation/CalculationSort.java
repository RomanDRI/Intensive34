package ru.aston.druzhinin_ri.task1.culculation;

import ru.aston.druzhinin_ri.task1.order.OrderCosmoTicket;

import java.math.BigDecimal;
import java.util.List;

public interface CalculationSort {
    BigDecimal priceCalculation();
    List<OrderCosmoTicket> getSortedList();
}
