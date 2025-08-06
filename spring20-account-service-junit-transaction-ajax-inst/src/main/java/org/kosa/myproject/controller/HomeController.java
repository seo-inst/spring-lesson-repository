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
}








