package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

	CalculationImpl calculation;

	@BeforeEach
	void initList() {
		User user = new User(32, "Roman", "Dru");
		User user1 = new User(31,"Alex", "Mag");

		OrderCosmoTicket cosmoTicket = new SuborbitalFlight(BigDecimal.valueOf(20), user, BigDecimal.valueOf(10000000),1, BigDecimal.valueOf(2));
		OrderCosmoTicket cosmoTicket1 = new OrbitalFlight(BigDecimal.valueOf(20),user1, BigDecimal.valueOf(20000000), 2, BigDecimal.valueOf(5));
		List<OrderCosmoTicket> list= new ArrayList<>();
		list.add(cosmoTicket);
		list.add(cosmoTicket1);
		calculation = new CalculationImpl(list);
	}


	@Test
	void calculationTest() {
		Assertions.assertEquals(new BigDecimal(2400000000.0), calculation.priceCalculation());
	}

	@Test
	void sortList(){
		Assertions.assertNotEquals(calculation, calculation.getSortedList());
	}


}
