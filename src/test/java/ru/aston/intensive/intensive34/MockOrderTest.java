package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.druzhinin_ri.task4.model.Order;
import ru.aston.druzhinin_ri.task4.model.User;
import ru.aston.druzhinin_ri.task4.repository.RepositoryData;
import ru.aston.druzhinin_ri.task4.repository.RepositoryImplOrder;

import java.util.List;

public class MockOrderTest {

    private static RepositoryImplOrder orderImpl = Mockito.mock(RepositoryImplOrder.class);
    private static RepositoryData data = Mockito.mock(RepositoryData.class);

    private static Order order = new Order(111);

    @Test
    void findAll() {
        Mockito.when(orderImpl.findAll()).thenReturn(List.of(new Order(1,111)));
        Assertions.assertNotNull(orderImpl.findAll());
    }

    @Test
    void findEntityById() {
        Mockito.when(orderImpl.findEntityById(1)).thenReturn(order);
        Assertions.assertInstanceOf(order.getClass(), orderImpl.findEntityById(1));
    }

    @Test
    void delete() {
        Mockito.when(orderImpl.delete(1)).thenReturn(true);
        Assertions.assertTrue(orderImpl.delete(1));
    }

    @Test
    void update() {
        Mockito.when(orderImpl.update(new Order(1, 222))).thenReturn(new Order());
        Assertions.assertInstanceOf(Order.class, orderImpl.update(new Order(1, 222)));
    }
}
