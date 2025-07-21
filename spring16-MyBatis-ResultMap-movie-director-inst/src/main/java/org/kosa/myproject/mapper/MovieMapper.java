package org.kosa.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Movie;

@Mapper
public interface MovieMapper {

	int getTotalCount();

	List<Movie> findMovieList();

	Movie findMovieById(Long movieId);

	int register(Movie movie);

}
