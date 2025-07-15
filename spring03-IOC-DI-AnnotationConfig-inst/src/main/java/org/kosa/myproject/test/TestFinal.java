package org.kosa.myproject.test;

public class TestFinal {
	private final String id;
	public TestFinal(String id) { // 생성자를 통한 할당은 가능 
		this.id=id;
	}
	public String getId() {
		return id;
	}
	//final field 일때 아래 방식 할당을 불가능.. 컴파일 에러 , 이유는 final은 재할당 안되기 때문 
//	public void setId() {
//		this.id=id;
//	}
}
