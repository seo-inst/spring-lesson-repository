package org.kosa.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class MemberService{
	// 직접 코드에 기술하는 방식은 많은 비용이 소모 
	//private static final Logger logger=LoggerFactory.getLogger(MemberService.class);
	public void findMemberById(String id) {			
		System.out.println(getClass().getName()+" core concern findMemberById");
	//	logger.debug("cross cutting MemberService findMemberById 검색어 {}",id);
	}

	public void findMemberByAddress(String address) {		
		System.out.println(getClass().getName()+" core concern findMemberByAddress");
	}
	
	public void findMemberListByDept(String dept) {		
		System.out.println(getClass().getName()+" core concern findMemberList");
	}

	public void register(String id,String name) {
		System.out.println(getClass().getName()+" core concern register");
	}	
}



