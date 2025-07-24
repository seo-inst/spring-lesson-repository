package org.kosa.myproject.domain;

public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	public Member() {
		super();		
	}
	public Member(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}	
	// thymeleaf 테스트를 위한 메서드를 추가한다 
	/*
	 *   자바 코딩 컨벤션
	 *  일반 반환형일때는 getter 메서드로  정의
	 *  boolean 형일때는 is 계열 메서드로 정의 
	 *  jsp 의 el 은  get 계열과 is 계열만 인스턴스 변수명으로만
	 *  접근 가능한데 thymeleaf 은 다양한 형식 즉 
	 *  인스턴스 변수명과 자유로운 메서드로도 접근 가능 
	 */
	public boolean isNextPageGroup() {
		System.out.println("isNextPageGroup method 호출");
		return true;
	}
//	public boolean getNextPageGroup() {
//		System.out.println("getNextPageGroup method 호출");
//		return true;
//	}
	public String methodTest() {
		return "타임리프는 자유도가 높음";
	}
}









