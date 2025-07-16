package org.kosa.myproject;

import org.kosa.myproject.model.MemberService;
import org.kosa.myproject.model.MemberServiceImpl;
import org.kosa.myproject.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *  요구 사항 -> AOP를 적용하여 공통 기능을 처리 또는 횡단 관심사를 처리
 *  spring08-AOP-basic 에서 AOP를 사용하지 않은 예와 비교해본다  
 *   
 *  요구사항 -> AOP로 처리할 공통 또는 횡단 관심사항( Cross Cutting Concern ) 
 *  현재  서비스 중인 시스템의 검색 계열 ( find 계열 ) 기능 메서드들을 대상으로 
 *  특정 업무를 메서드 코어 작업 실행 직전에 수행하도록 작업을 추가해야 한다 
 *  대상 서비스 클래스들과 메서드들이 다수가 존재하는 것으로 전제하고 
 *  공통된 업무 즉 추가 요구 사항을 적용해본다 
 *  
 *  검색 계열 메서드 실행전에  
 *  ***cross cutting concern***MemberService **** findMemberById *** 공통 로그 출력 
 *  
	 AOP 적용 단계 
	 1.  maven  pom.xml  에 AOP  의존성 추가 	
     2.  Cross Cutting Concern 횡단 관심사 , 공통 관심사 로직 정의 클래스 구현 
     3. AOP 설정 :  xml or Annotation  기반 AOP 설정 
 
      AOP 적용 후 개선된 점 
      1.  여러 서비스에서 반복적으로 작업하던 공통 작업을  AOP 별도 모듈에서 한번 정의해서 사용 
      2.  이후 공통 작업 ( Cross Cutting Concern  횡단 관심사 or 공통 관심사 ) 의 업무가 변경되어도 
          여러 곳을 수정 작업 필요없고  오직 AOP 모듈만 업데이트 하면 된다 
          높은 응집도 high cohesion    :  Core 은 Core에만 집중 ,  Cross cutting 은 별도로 전담 
          낮은 결합도 loose coupling    :  Cross cutting 이 변경되어도  Core 에는 영향이 없음 
      
 */
@SpringBootApplication
public class Spring09AopSolutionApplication implements CommandLineRunner{
	@Autowired // field Injection 
	private MemberService memberService;
	@Autowired
	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(Spring09AopSolutionApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		// 직접 객체를 만들어서 확인 
		MemberService testMs=new MemberServiceImpl();// 실제 구현체 
		testMs.findMemberByAddress();// AOP 적용 안됨 
		System.out.println("**테스트를 위해 직접 객체를 생성해서 호출해봄**");
		System.out.println(testMs.getClass().getName());//실제 구현체 
		//아래는 Spring Container 가 주입해준 Proxy (CGLIB) 대리인 객체 
		// AOP 가 적용 ( Proxy 대리인이 aop 기능 실행하고 core 를 실행 ) 
		System.out.println(memberService.getClass().getName());
		System.out.println(productService.getClass().getName());
		memberService.findMemberByAddress();
		memberService.findMemberById();
		memberService.findMemberList();
		memberService.register();		
		productService.findProductById();
		productService.findProductByName();
		productService.findProductListByMaker();
		productService.updateProduct();		
	}
}








