package org.kosa.myproject.controller;

import org.kosa.myproject.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
// Thymeleaf 연습을 위한 컨트롤러 
@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message","안녕 백리향");
		model.addAttribute("logo", "thymeleaf-admin.png");
		return "index";
	}
	@GetMapping("/study1")
	public String study1(Model model) {
		model.addAttribute("member", new Member("java","A","손흥민","런던"));
		return "step01-text-object-expression";
	}
	@GetMapping("/study2")
	public String study2(HttpSession session) {
		// request scope 에 저장됨 
		//model.addAttribute("member", new Member("spring","A","이강인","파리"));
		
		// session scope 에 저장됨 
		session.setAttribute("member", new Member("thymeleaf","A","황희찬","울버햄튼"));
		return "step02-form-object-expression";
	}
	@GetMapping("/study3")
	public String study3(Model model) {
		model.addAttribute("pageNo", 9);
		model.addAttribute("keyword", "월드컵");
		model.addAttribute("orderId", "77");
		model.addAttribute("maker", "삼성");
		return "step03-link-href-querystring";
	}
	// <a href="/board/list?pageNo=9">
	@GetMapping("/board/list")
	public String studyResult(int pageNo,String keyword) {//왜 매개변수명이 중요할까?
		System.out.println("페이지 번호:"+pageNo+" 키워드:"+keyword);
		return "step03-result1-param";
	}
	@GetMapping("/order/details")
	public String orderDetails(int orderId,String maker) {
		return "step03-result2-param";
	}
	@GetMapping("/study4")
	public String study4(HttpSession session) {
		session.setAttribute("mvo", new Member("transaction","a","이강인","파리"));
		return "step04-session-param";
	}
	@GetMapping("/study4-test")
	public String study4Test(Member member) {
		System.out.println(member);
		return "step04-session-param-result";
	}
}
































