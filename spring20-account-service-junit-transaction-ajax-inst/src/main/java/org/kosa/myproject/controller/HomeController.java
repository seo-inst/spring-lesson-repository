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
}








