package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

/**
 *  DI 연습 예제 
 *  @Service : 비즈니스 또는 서비스 계층(Layer) 을 담당하는 클래스에 명시하는 
 *  				  @Component 계열 하위의 애너테이션 
 *  				  스프링 컨테이너에게 bean 으로 생성, 관리하라고 표현하는 역할은 동일함 
 *  				 @Component 의 하위 애너테이션으로써  이후 더 상세한 제어를 위해 
 *                   사용되는 경우 및 가독성 향상을 목적으로 함 
 */
@Service  
public class WorkerServiceImpl implements WorkerService {
	// IOC  DI 중 field Injection 
//	@Autowired // DI 애너테이션 : 타입으로 비교하여 동일한 타입이 있으면 bean 을 주입 
//	@Qualifier("hammer") // 타입이 동일한 여러 컴포넌트 중 특정 bean 을 지정하여 DI 
	private final Tool tool; // final :  불변성 보장 및 초기화 강제 
	// spring 4 버전 이후 ( 2025 현재 6 버전 )  생성자 1 개일 경우 별도의 DI 설정 없이 자동 주입됨 
	//@Autowired // 생략해도 Spring Container가 알아서 주입 
	public WorkerServiceImpl(Tool tool) {
		super();
		this.tool = tool;
	}

	@Override
	public void service() {
		System.out.println("일꾼 시스템 서비스 시작");
		tool.work();		
		System.out.println("일꾼 시스템 서비스 마무리");
	}
}







