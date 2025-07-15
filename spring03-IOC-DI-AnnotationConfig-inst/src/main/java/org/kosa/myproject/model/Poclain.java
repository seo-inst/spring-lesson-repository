package org.kosa.myproject.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("tool")
@Component
@Primary // 동일한 타입의 Component 중 최우선적으로 선택되도록 설정하는 애너테이션 
public class Poclain  implements Tool{
	@Override
	public void work() {
		System.out.println("포크레인으로 일하다");
	}	
}
