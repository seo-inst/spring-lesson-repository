DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS director;

-- 감독 테이블 
CREATE TABLE director (
    director_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    director_name VARCHAR(100) NOT NULL,
    intro VARCHAR(100) NOT NULL
);

-- 영화 테이블 생성
-- Oracle과의 차이점:

CREATE TABLE movie (
    movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    attendance BIGINT DEFAULT 0,
    director_id BIGINT NOT NULL,
    CONSTRAINT fk_movie_director_id 
        FOREIGN KEY (director_id) REFERENCES director(director_id)
        ON DELETE CASCADE  
);

SELECT * FROM director;
SELECT * FROM movie;


DELETE FROM movie;     
DELETE FROM director;



COMMIT;


-- 감독 데이터 삽입
INSERT INTO director (director_name, intro) VALUES 
('봉준호', '기생충, 설국열차로 유명한 한국의 세계적 감독'),
('박찬욱', '헤어질 결심, 올드보이, 아가씨로 유명한 스타일리시한 감독'),
('최동훈', '도둑들, 암살로 유명한 블록버스터 감독');

-- 영화 데이터 삽입
INSERT INTO movie (title, genre, attendance, director_id) VALUES 
('기생충', '드라마', 10085374, 1),
('설국열차', 'SF', 9347447, 1),
('올드보이', '스릴러', 3260000, 2),
('아가씨', '스릴러', 4226000, 2),
('도둑들', '액션', 12983330, 3);

COMMIT