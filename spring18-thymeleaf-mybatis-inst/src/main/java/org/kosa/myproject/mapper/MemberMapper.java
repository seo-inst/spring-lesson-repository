package org.kosa.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	int getTotalMemberCount();
}
