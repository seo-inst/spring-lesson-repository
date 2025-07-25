package org.kosa.myproject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Member;

@Mapper
public interface MemberMapper {

	List<Map<String, String>> findMemberMapList();

	int insertMember(Member member);

}
