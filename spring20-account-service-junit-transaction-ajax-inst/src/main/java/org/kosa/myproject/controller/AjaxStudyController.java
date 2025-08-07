package org.kosa.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// @RestController : @Controller + @ResponseBody => 이후 공부 
@Controller
public class AjaxStudyController {
	@GetMapping("/test-ajax1")
	@ResponseBody // ajax 응답을 위한 설정 , 페이지가 아니라 필요한 데이터로 응답 ( text or JSON ) 
	public String testAjax1(String userId) {
		System.out.println(userId);
		return "hello ajax "+userId;
	}
}












