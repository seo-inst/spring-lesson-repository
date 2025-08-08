package org.kosa.myproject.controller;

import java.util.List;

import org.kosa.myproject.domain.Account;
import org.kosa.myproject.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @RestController : @Controller + @ResponseBody
@Controller
@RequestMapping("/api/accounts") // api/복수형
public class AjaxStudyAccountController {
	private final AccountService accountService;
	public AjaxStudyAccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@GetMapping("/{accountNumber}") //  /api/accounts/1 ==> 1 계좌번호의 계좌 조회
	@ResponseBody // @ResponseBody 와 Jackson 라이브러리가 동작되어 JSON으로 자동 변환되어 응답
	public Account getAccountByNumber(@PathVariable Long accountNumber) {//@PathVariable로 경로의 값을 매개변수에 할당 받을 수 있음 		
		return accountService.getAccountByNumber(accountNumber);
	}
	// 고객별 계좌 리스트 조회 
	// URL :  /api/accounts/customer/2
	@GetMapping("/customer/{customerId}")
	@ResponseBody
	public List<Account> getAccountsByCustomer(@PathVariable Long customerId){
		return accountService.getAccountListByCustomerId(customerId);
	}
}















