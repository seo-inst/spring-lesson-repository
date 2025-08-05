package org.kosa.myproject.service;

import org.kosa.myproject.domain.Customer;
import org.kosa.myproject.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 비즈니스 계층 , Service Layer , 업무정의(작업단위) , 트랜잭션 처리 
@Transactional // AOP 기반 트랜잭션 처리 : 문제 발생시 자동 롤백, 정상 수행 커밋
//위의 @Transactional 을 클래스 단위에서 설정하면 하위의 모든 메서드들이 트랜잭션 관리가 된다 
public class CustomerService {
	private final CustomerMapper customerMapper;
	public CustomerService(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}
	public Customer registerCustomer(Customer customer) {
		 validateCustomerInput(customer);// 등록될 고객 정보를 검증한다 
		 // 고객 등록 작업 수행
		 int result = customerMapper.register(customer);
		 if(result != 1) // 만약 별도의 Exception 을 구성할 때는 RuntimeException 하위를 권장
			 throw new RuntimeException("고객 등록에 실패했습니다");
		return customer;
	}
	private void validateCustomerInput(Customer customer) {
		if(customer == null) {
			// 아래 IllegalArgumentException 은 RuntimeException 의 하위 
			//  Spring AOP 기반 트랜잭션 적용시에는 RuntimeException 계열의 
			// Exception 이 발생할 때 자동 롤백되는 구조입니다.
			throw new IllegalArgumentException("고객 정보가 없습니다");
		}
		if(customer.getName()==null || customer.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("고객명을 입력하세요");
		}
		if(customer.getEmail()==null || customer.getEmail().trim().isEmpty()) {
			throw new IllegalArgumentException("이메일을 입력하세요");
		}
	}
	/**
	 * @Transactional(readOnly = true)
	 * 위 설정이 명시된 메서드는 트랜잭션 상에서 데이터 변경을 하지 않을 것임을 알림
	 * ==> 읽기 작업에만 집중하게 하여 성능 향상 
	 */
	@Transactional(readOnly = true) // 조회 전용 트랜잭션 ( 성능 최적화 ) 
	public Customer findById(Long customerId) {
		if(customerId == null || customerId <=0 )
			throw new IllegalArgumentException("올바른 고객 아이디를 입력하세요");
		return customerMapper.findById(customerId);
	}
}










