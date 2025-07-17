package org.kosa.myproject;

import org.kosa.myproject.model.board.BoardService;
import org.kosa.myproject.model.member.DuplicateIdException;
import org.kosa.myproject.model.member.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class PerformanceCheckRunner implements CommandLineRunner {
    	private final BoardService boardService;	
    private final MemberService memberService;
    //@Autowired  생략 가능 : 스프링 컨테이너가  하나의 생성자 (매개변수 개수는 상관없음) 일 경우에는
    // 자동 DI 
	public PerformanceCheckRunner(BoardService boardService, MemberService memberService) {
		super();
		this.boardService = boardService;
		this.memberService = memberService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("main:"+boardService.find());
		System.out.println("main:"+boardService.findAllList());
		memberService.findMember();
		memberService.findAllMember();
		try {
		memberService.register("java", "아이유");
		}catch(DuplicateIdException e) {
			System.out.println("main:"+e.getMessage());
		}
	}
}













