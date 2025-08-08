package org.kosa.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/ajax-study1")
	public String ajaxStudy() {
		return "ajax-study1";
	}
	@GetMapping("/ajax-study2")
	public String ajaxStudy2() {
		return "ajax-study2-jquery";// thymeleaf template view 
	}
	@GetMapping("/ajax-study3")
	public String ajaxStudy3() {
		return "ajax-study3-fetch";// thymeleaf template view 
	}
	@GetMapping("/ajax-study4")
	public String ajaxStudy4() {
		return "ajax-study4-account-fetch-json";// thymeleaf template view 
	}
}








