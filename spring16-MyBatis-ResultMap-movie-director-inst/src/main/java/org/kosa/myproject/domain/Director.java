package org.kosa.myproject.domain;
/**
 * 감독 정보를 담는 도메인 모델 
 * 관련 개념 : Domain Driven Design ( DDD ) 
 * 비즈니스 도메인의 핵심 개념을 코드로 표현 
 *  감독 Director 는 영화 산업에서 중요한 비즈니스 개체 
 */
public class Director {
	private Long directorId;
	private String directorName;
	private String intro;
	public Director() {
		super();	
	}
	// 비즈니스 생성자 : 새로운 감독 등록시 사용 (ID 제외) 
	public Director(String directorName, String intro) {
		super();
		this.directorName = directorName;
		this.intro = intro;
	}
	// 개별 또는 전체 감독 정보를 반환받을 때 사용 
	public Director(Long directorId, String directorName, String intro) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.intro = intro;
	}
	public Long getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	//  비즈니스 메서드의 예 
	//  간단한 예를 들어본다면 다음과 같은 유효성 검증 메서드를 Domain class 에 정의할 
	// 수 있음 
	public boolean isValidIntro() {
		return intro !=null && intro.isEmpty()==false && intro.length()<1000;
	}
	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", intro=" + intro + "]";
	}
	
}










