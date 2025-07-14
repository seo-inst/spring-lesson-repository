package org.kosa.myproject.model;

import org.springframework.stereotype.Component;

@Component // Spring Container 에게  컴포넌트임을 알리는 애너테이션 - > scan 시에 bean 으로 생성해서 관리해 주세요
//별도의 명시가 없으면 소문자로 시작하는 클래스명이 자신의 bean name  이 된다 : hammer 로 bean 이 등록 
public class Hammer implements Tool{
	public void work() {
		System.out.println("망치로 일하다");
	}
}
