package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.druzhinin_ri.task1.culculation.CalculationImpl;
import ru.aston.druzhinin_ri.task1.order.OrbitalFlight;
import ru.aston.druzhinin_ri.task1.order.OrderCosmoTicket;
import ru.aston.druzhinin_ri.task1.order.SuborbitalFlight;
import ru.aston.druzhinin_ri.task1.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class Intensive34ApplicationTests {

	@Test
	void calculationTest() {
		User user = new User(32, "Roman", "Dru");
		User user1 = new User(31,"Alex", "Mag");

		OrderCosmoTicket cosmoTicket = new SuborbitalFlight(user, BigDecimal.valueOf(10000000),1);
		OrderCosmoTicket cosmoTicket1 = new OrbitalFlight(user1, BigDecimal.valueOf(20000000), 2);
		List<OrderCosmoTicket> list= new ArrayList<>();
		list.add(cosmoTicket);
		list.add(cosmoTicket1);

		CalculationImpl calculation = new CalculationImpl(list);

		Assertions.assertEquals(new BigDecimal(30000000), calculation.priceCalculation());
	}

}
