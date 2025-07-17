package org.kosa.myproject.model;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private int productCount = 5;
	public void register(String productName) {
		System.out.println("register product:"+productName);
	}
	public String getMaker() {
		return "오뚜기";
	}
	public void sellProduct(int count) throws InventoryException {
		if(productCount<count) {
			throw new InventoryException("재고 수량이 부족합니다");
		}
		System.out.println("상품 판매.. 판매수량:"+count);
	}
	public void buyProduct(int count) throws SQLException{
		if(count<=0)
			throw new SQLException("잘못된 구매수량");
		System.out.println("상품 구매.. 구매 수량:"+count);
	}
}













