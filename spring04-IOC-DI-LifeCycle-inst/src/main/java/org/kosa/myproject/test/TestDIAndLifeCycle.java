package org.kosa.myproject.test;

import org.kosa.myproject.config.AppConfig;
import org.kosa.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDIAndLifeCycle {
	public static void main(String[] args) {
		// 스프링 IOC 컨테이너를 생성한다( 시작 한다 ) : 시작 시점에 AppConfig 설정을 로딩한다 
		AnnotationConfigApplicationContext  factory=new AnnotationConfigApplicationContext(AppConfig.class);
		// IOC , DL 
		ProductService service=(ProductService)factory.getBean("productService");
		String result=service.findProductById("1");
		System.out.println(result);
		factory.close();
	}
}






