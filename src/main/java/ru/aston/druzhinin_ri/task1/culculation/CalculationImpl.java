package ru.aston.druzhinin_ri.task1.culculation;

import ru.aston.druzhinin_ri.task1.order.OrderCosmoTicket;

import java.math.BigDecimal;
import java.util.List;

public class CalculationImpl implements Calculation{
    private BigDecimal resultSum;
    private List<OrderCosmoTicket> calculationList;

    public CalculationImpl(List<OrderCosmoTicket> orderList) {
        this.calculationList = orderList;
    }

    @Override
    public BigDecimal priceCalculation() {
        resultSum = BigDecimal.ZERO;
        for (OrderCosmoTicket OrderCosmoTicket : this.calculationList){
            resultSum = resultSum.add(OrderCosmoTicket.getPrice());
        }
        return resultSum;
    }
}
