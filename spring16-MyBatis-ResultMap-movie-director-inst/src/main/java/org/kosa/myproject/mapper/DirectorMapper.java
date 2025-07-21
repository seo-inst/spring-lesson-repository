package org.kosa.myproject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Director;
@Mapper
public interface DirectorMapper {

	List<Director> findDirectorAllList();

	List<Map<String, Object>> findDirectorStatistics();

}
