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
		//int totalCount = memberMapper.getTotalMemberCount();
		//System.out.println("총 회원수:"+totalCount);
		
		// insert test 
//		Member member = new Member("mybatis","a","이강인","파리");
//		int registerResult=memberMapper.register(member);
//		System.out.println("회원 등록 "+registerResult);// 등록 회원수 
		
		// select test 
		// Mapper xml  에서  parameterType="String"  resultType="org.kosa.myproject.domain.Member" 을 명시하면 됨 
	//	Member member = memberMapper.findMemberById("mybatis");
	//	System.out.println(member);// 회원정보 toString 이 출력 : 이강인 정보가 출력 
		
		// select List test
//		 List<Member> list=memberMapper.findAllMemberList();
//		 for(Member m:list)
//			 System.out.println(m);
		
		// update member 
//		System.out.println("수정전:"+memberMapper.findMemberById("mybatis"));
//		Member paramVo = new Member("mybatis","b","황희찬","울버햄튼");
//		// id 가  mybatis 인 회원의 password 와 name 과 address 를 수정한다 
//		int updateResult = memberMapper.updateMember(paramVo);
//		System.out.println("회원정보 수정:"+updateResult);
//		System.out.println("수정후:"+memberMapper.findMemberById("mybatis"));
		
		// delete member
		String id = "mybatis";
		System.out.println(memberMapper.findMemberById(id));// 황희찬 회원 조회됨 
		int deleteResult = memberMapper.deleteMember(id);
		System.out.println("삭제:"+deleteResult);// 삭제 1 
		System.out.println(memberMapper.findMemberById(id));// null 
	}
}











