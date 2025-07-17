package org.kosa.myproject;

import org.kosa.myproject.model.MemberService;
import org.kosa.myproject.model.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartRunner implements CommandLineRunner{
	private final MemberService memberService;
	private final ProductService productService;
	//@Autowired 생략 가능 
	public MyStartRunner(MemberService memberService, ProductService productService) {
		super();
		this.memberService = memberService;
		this.productService = productService;
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(getClass()+ " run 실행");
		System.out.println(memberService.getClass().getName());
		System.out.println(productService.getClass().getName());
		memberService.findMemberByAddress("종로");
		memberService.findMemberById("java");
		memberService.findMemberListByDept("영업부");
		memberService.register("java","손흥민");		
		productService.findProductById("1");
		productService.findProductByName("빈대떡");
		productService.findProductListByMaker("광장시장");
		productService.updateProduct("카스","오비",2000);		
	}
}







