package org.kosa.myproject.model;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private final MemberDao memberDao;
	// @Autowired  // DI 애너테이션 생략 가능 -> 생성자 1 개 일 경우 자동 DI 의존성 주입 
	public MemberService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	public MemberVo findMemberById(String id) throws SQLException {
		return memberDao.findMemberById(id);
	}
}
