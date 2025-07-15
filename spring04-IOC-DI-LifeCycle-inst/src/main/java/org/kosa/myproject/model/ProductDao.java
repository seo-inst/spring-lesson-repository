package org.kosa.myproject.model;

import org.springframework.stereotype.Repository;
// 영속성 계층 ( persistence Layer ) 에 명시하는 애너테이션 : Bean으로 생성 
@Repository
public class ProductDao {
	
	public ProductDao() {
		System.out.println(getClass()+" 생성자 실행-> 객체 생성");
	}

	public String findProductById(String id) {
		return id+"번 Product 정보";
	}
}
