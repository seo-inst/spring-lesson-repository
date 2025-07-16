package com.example.spring07.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceManager {
	// @Bean 애너테이션 :  @Configuration 이 명시된 클래스 내부의 메서드에 사용하는 애너테이션 
			// 메서드의 리턴값을 Bean 으로 생성해 관리 , 주로 외부 라이브러리에 의한 객체를 Bean 으로 생성 관리할 때 사용 
			@Bean  
			public DataSource dataSource() {
				BasicDataSource dataSource = new BasicDataSource();
				dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
				dataSource.setUrl("jdbc:mysql://localhost:3306/kosa?serverTimezone=UTC");
				dataSource.setUsername("joyofbeing");  
				dataSource.setPassword("1234");
				return dataSource;
			}
}
