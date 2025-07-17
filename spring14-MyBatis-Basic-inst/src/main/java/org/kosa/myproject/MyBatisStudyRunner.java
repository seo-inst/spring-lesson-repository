package org.kosa.myproject;

import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MyBatisStudyRunner implements CommandLineRunner {
	private final MemberMapper memberMapper;
	
	public MyBatisStudyRunner(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	@Override
	public void run(String... args) throws Exception {
		int totalCount = memberMapper.getTotalMemberCount();
		System.out.println("총 회원수:"+totalCount);
	}
}
