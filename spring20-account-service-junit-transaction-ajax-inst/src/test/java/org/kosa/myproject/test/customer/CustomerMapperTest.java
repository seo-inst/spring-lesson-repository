package org.kosa.myproject.test.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.kosa.myproject.domain.Customer;
import org.kosa.myproject.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
/**
 *  @SpringBootTest : 테스트를 위한 Spring ApplicationContext 를 로딩함 
 *  							    모든 bean 을 자동 스캔 , 설정 해서 실제 스프링 어플리케이션이 
 *  							    구동되는 것과 동일한 환경에서 테스트를 실행할 수 있게 함 
 *  @Transactional :  일반적으로 비즈니스 계층(서비스 계층)에서 트랜잭션 처리를 위한 
 *  							  애너테이션이다. ( 내부적으로 AOP 가 동작됨 ) 
 *  							  트랜잭션 ( 작업단위 ) 내 세부 실행에서 문제 발생시 자동 롤백,
 *  							  문제가 없이 모두 잘 수행되었을 때 커밋되도록 처리한다 
 *  테스트 환경에서 @SpringBootTest 과 @Transactional  을 함께 사용하면 
 *  테스트를 위한 특별한 지원이 있음 
 *  각 테스트 메서드가 실행될 때마다 하나의 트랜잭션을 시작하고
 *  테스트 메서드가 종료되면 그 트랜잭션을 자동으로 ROLLBACK(롤백) 시킴 
 *  
 */
@SpringBootTest
@Transactional
public class CustomerMapperTest {
	@Autowired // DI 
	private CustomerMapper customerMapper;	
	
	@Test
	public void testMapper() {
		assertNotNull(customerMapper);
	}
	@Test
	public void testTotalCount() {
		assertEquals(3, customerMapper.getTotalCount());
	}
	/**
	 *  고객 등록 기능 테스트 
	 *  @Transactional 을 테스트 클래스에서 적용하면 
	 *  테스트 단계에서 등록 기능을 검증 한 후 자동 롤백됨 
	 */
	@Test
	public void testRegister() {
		// Given : 테스트용 고객 데이터 준비
		Customer customer = new Customer("이한범","lee@gmail.com");
		System.out.println("등록 전:"+customer);
		// When : 고객 등록 실행
		int insertResult=customerMapper.register(customer);
		// Then :  등록 결과 검증
		assertEquals(1, insertResult);
		System.out.println("등록 후:"+customer);
	}
	@Test
	public void testFindById() {
		// Given :  조회할 고객 아이디 
		Long customerId=4L;
		// When : 등록된 고객을 아이디로 조회 
		Customer foundCustomer = customerMapper.findById(customerId);
		// Then : 조회 결과 검증
		assertNotNull(foundCustomer);
		assertEquals("황인범", foundCustomer.getName());
	}
}










