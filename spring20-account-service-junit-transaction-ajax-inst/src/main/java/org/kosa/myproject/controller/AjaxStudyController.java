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
		//System.out.println(userId);
		try { 
			// 서버 로직이 복잡하여 시간 소요가 많이 될 수 
			// 있다고 가정 
			Thread.sleep(10000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return "hello ajax "+userId;
	}
	@GetMapping("/test-ajax2")
	@ResponseBody // ajax 응답을 위한 설정 , 페이지가 아니라 필요한 데이터로 응답 ( text or JSON ) 
	public String testAjax2(String userId) {
		//System.out.println(userId);
		try { 
			// 서버 로직이 복잡하여 시간 소요가 많이 될 수 있다고 가정 
			Thread.sleep(10000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return "hello jQuery ajax "+userId;
	}
	@GetMapping("/test-ajax3")
	@ResponseBody // ajax 응답을 위한 설정 
	public String testAjax3(String userId) {
		//System.out.println(userId);
		try { 
			// 서버 로직이 복잡하여 시간 소요가 많이 될 수 있다고 가정 
			Thread.sleep(10000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return "hello fetch ajax "+userId;
	}
}












