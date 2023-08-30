package ru.aston.druzhinin_ri.task1.culculation;

import ru.aston.druzhinin_ri.task1.order.OrderCosmoTicket;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CalculationImpl implements CalculationSort {
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

    public List<OrderCosmoTicket> getSortedList(){
        Collections.sort(calculationList);
        return this.calculationList;
    }
}
