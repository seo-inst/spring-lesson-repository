package org.kosa.myproject.test.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.kosa.myproject.domain.Customer;
import org.kosa.myproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // @SpringBootTest 에 설정한 @Transactional  은 각 테스트가  실행된 후에는 자동 롤백 
public class CustomerServiceTest {
	@Autowired	
	private CustomerService customerService;
	@Test
	void testService() {
		assertNotNull(customerService);
		System.out.println(customerService.getClass().getName());
	}
	@Test
	void testRegisterCustomer() {
		//Given : 고객 등록 
		Customer customer = new Customer("서비스테스터","service@test.com");
		Customer   registeredCustomer = customerService.registerCustomer(customer);
		assertNotNull(registeredCustomer,"등록된 고객 정보가 반환되어야 함");
		assertTrue(registeredCustomer.getCustomerId()>0,"생성된 고객 ID는 양수이어야 함");
		assertEquals("service@test.com", registeredCustomer.getEmail(),"이메일 일치해야 함");
		System.out.println("등록된 고객:"+registeredCustomer);
	}
	/**
	 *  고객 조회 기능 테스트 
	 *  고객 테스트 데이터로 등록 후 조회한 고객 데이터가 일치하는 지 확인
	 */
	@Test
	void testFindById() {
		// Given : 조회 테스트를 위한 고객 등록 
		Customer customer = new Customer("고객명조회테스트","find@service.com");
		Customer registeredCustomer = customerService.registerCustomer(customer);
		Long customerId = registeredCustomer.getCustomerId();
		
		// When : 고객 조회 
		Customer foundCustomer = customerService.findById(customerId);
		
		// Then : 조회 결과 검증 
		assertNotNull(foundCustomer,"고객 정보가 조회되어야 함");
		assertEquals(customerId, foundCustomer.getCustomerId(),"고객 아이디가 일치해야 함");
		//.... 등등의 검증 테스트 
		System.out.println("조회된 고객:"+foundCustomer);
	}
}











