package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.aston.druzhinin_ri.task4.model.Order;
import ru.aston.druzhinin_ri.task4.repository.RepositoryData;
import ru.aston.druzhinin_ri.task4.repository.RepositoryImplOrder;

import java.util.List;

public class MockOrderTest {

    private static Order order = new Order(111);

    @Test
    void usersDAOImlMockitoTest(){
        RepositoryImplOrder orderImpl = Mockito.mock(RepositoryImplOrder.class);
        RepositoryData data = Mockito.mock(RepositoryData.class);
        Mockito.when(data.scriptRun()).thenReturn(true);
        Mockito.when(orderImpl.findEntityById(1)).thenReturn(order);
        Mockito.when(orderImpl.findAll()).thenReturn(List.of(new Order(1,111)));
        Mockito.when(orderImpl.update(new Order(1, 222))).thenReturn(new Order());
        Mockito.when(orderImpl.delete(1)).thenReturn(true);

        Assertions.assertAll(
                () -> Assertions.assertTrue(data.scriptRun()),
                () -> Assertions.assertInstanceOf(order.getClass(), orderImpl.findEntityById(1)),
                () -> Assertions.assertNotNull(orderImpl.findAll()),
                () -> Assertions.assertInstanceOf(Order.class, orderImpl.update(new Order(1, 222))),
                () -> Assertions.assertTrue(orderImpl.delete(1))
        );
    }
}
