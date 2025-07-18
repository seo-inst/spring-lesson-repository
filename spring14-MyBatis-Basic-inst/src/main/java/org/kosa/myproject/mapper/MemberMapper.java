package org.kosa.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Member;

@Mapper
public interface MemberMapper {
	int getTotalMemberCount();
	int register(Member member);
	Member findMemberById(String id);
	List<Member> findAllMemberList();
}
