package org.kosa.myproject.test;

import org.kosa.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOCWorker {
	public static void main(String[] args) {
		// ApplicationContext : Spring IOC Container 
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
		Tool tool1=(Tool)factory.getBean("spade"); // IOC 의 DL ( Dependency Lookup 검색 ) 
		tool1.work();
		Tool tool2=(Tool)factory.getBean("hammer"); // IOC 의 DL ( Dependency Lookup 검색 ) 
		tool2.work();
		factory.close();
	}
}





