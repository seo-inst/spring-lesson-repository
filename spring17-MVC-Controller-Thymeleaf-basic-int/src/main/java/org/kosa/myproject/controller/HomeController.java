package org.kosa.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping({"/","/home"})
	public String home(Model model) {
		// 뷰로 데이터를 공유 : request.setAttribute("result",""); // 와 동일한 역할 
		model.addAttribute("result","Hello SpringBoot Web Thymeleaf");
		return "index";//  viewResolver 에 의해 src/main/resources/templates/index.html 이 실행
	}
}






