package org.kosa.myproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// 현 클래스가 스프링 설정 클래스임을 알림 
@Configuration
// 지정한 패키지 이하 모든 패키지와 클래스들을 스캔하여 
// 컴포넌트 계열 애너테이션 명시된 클래스들을 bean 으로 생성 , 관리하고
// DI 관련 애너테이션 명시된 것에 의거해 DI(의존성 주입) 를 처리한다 
@ComponentScan("org.kosa.myproject.model")
public class AppConfig {

}
