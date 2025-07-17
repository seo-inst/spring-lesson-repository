package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class ProductService{

	public void updateProduct(String name,String maker,int price) {
		System.out.println(getClass().getName()+" core concern updateProduct");
	}

	public void findProductById(String id) {
		System.out.println(getClass().getName()+" core concern findProductById");
	}
	
	public void findProductByName(String name) {
		System.out.println(getClass().getName()+" core concern findProductByName");
	}

	public void findProductListByMaker(String maker) {
		System.out.println(getClass().getName()+" core concern findProductListByMaker");
	}
}









