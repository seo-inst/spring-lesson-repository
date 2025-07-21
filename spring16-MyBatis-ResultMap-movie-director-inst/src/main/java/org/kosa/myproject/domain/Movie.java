package org.kosa.myproject.domain;
/**
 * 영화 정보를 저장하는 도메인 모델 
 * Movie 와 Director 간의 Many To One 
 * 하나의 감독은 여러 영화를 만들수 있음 
 * 하나의 영화는 하나의 감독을 가지는 비즈니스 로직을 표현 
 */
public class Movie {
	private Long movieId;
	private String title;
	private String genre;
	private Long attendance;
	// 감독정보 : Movie has a Director 
	private Director director;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 비즈니스 생성자 - 새로운 영화 등록시 사용 
	public Movie(String title, String genre, Long attendance, Director director) {
		super();
		this.title = title;
		this.genre = genre;
		this.attendance = attendance;
		this.director = director;
	}

	public Movie(Long movieId, String title, String genre, Long attendance, Director director) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.attendance = attendance;
		this.director = director;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Long getAttendance() {
		return attendance;
	}
	public void setAttendance(Long attendance) {
		this.attendance = attendance;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", attendance=" + attendance
				+ ", director=" + director + "]";
	}
	
}














