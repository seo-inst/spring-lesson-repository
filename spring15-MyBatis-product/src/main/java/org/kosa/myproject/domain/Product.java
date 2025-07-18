package org.kosa.myproject.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {  
	//Wrapper class 타입 Long 으로 처리하는 바람직함 
	//값이 존재하지 않을때는 null 로 초기화됨 
	private Long productId; // table 의 column  : product_id BIGINT
	private String productName; // app은 camel case , db column 은 underscore  product_name
	private String maker;
	private BigDecimal price;//db decimal => 정확한 연산 , 환율 등 금액 계산
	private LocalDateTime createdAt;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long productId, String productName, String maker, BigDecimal price, LocalDateTime createdAt) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.maker = maker;
		this.price = price;
		this.createdAt = createdAt;
	}
	public Product(String productName, String maker, BigDecimal price) {
		super();
		this.productName = productName;
		this.maker = maker;
		this.price = price;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public LocalDateTime getCreateAt() {
		return createdAt;
	}
	public void setCreateAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", maker=" + maker + ", price="
				+ price + ", createAt=" + createdAt + "]";
	}
	
}











