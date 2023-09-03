package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.druzhinin_ri.task1.culculation.CalculationImpl;
import ru.aston.druzhinin_ri.task1.order.OrbitalFlight;
import ru.aston.druzhinin_ri.task1.order.OrderCosmoTicket;
import ru.aston.druzhinin_ri.task1.order.SuborbitalFlight;
import ru.aston.druzhinin_ri.task1.model.User;
import ru.aston.druzhinin_ri.task2.exception.CustomException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class Intensive34ApplicationTests {

	CalculationImpl calculation;

	@BeforeEach
	void initList() throws CustomException {
		User user = new User(32, "Roman", "Dru");
		User user1 = new User(31,"Alex", "Mag");

		OrderCosmoTicket cosmoTicket = new SuborbitalFlight(new BigDecimal(10000000), user,1, new BigDecimal("0.8"));
		OrderCosmoTicket cosmoTicket1 = new OrbitalFlight(new BigDecimal(20000000), user1,2, new BigDecimal("0.9"));
		List<OrderCosmoTicket> list= new ArrayList<>();
		list.add(cosmoTicket);
		list.add(cosmoTicket1);
		calculation = new CalculationImpl(list);
	}


	@Test
	void calculationTest() {
		Assertions.assertEquals(new BigDecimal("26000000.0"), calculation.priceCalculation());
	}

	@Test
	void sortList(){
		Assertions.assertNotEquals(calculation.getSortedList().get(0).getUser().getName(), "Alex");
		Assertions.assertNotEquals(calculation.getSortedList().get(1).getUser().getName(), "Roman");
	}


}
