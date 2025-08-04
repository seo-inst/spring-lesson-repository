package org.kosa.myproject.domain;

public class Customer {
	private Long customerId;
	private String name;
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 새로운 고객 등록시 사용 ( ID 는 DB에서 자동 생성 ) 
	 * @param name
	 * @param email
	 */
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	/**
	 * DB 조회 결과 매핑시 사용 
	 * @param customerId
	 * @param name
	 * @param email
	 */
	public Customer(Long customerId, String name, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + "]";
	}
	
}







