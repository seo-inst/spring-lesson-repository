package org.kosa.myproject.test.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.kosa.myproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CustomerServiceTest {
	@Autowired
	
	private CustomerService customerService;
	@Test
	void testService() {
		assertNotNull(customerService);
	}
}


