CREATE TABLE spring_member(
	id VARCHAR(100) PRIMARY KEY,
	password VARCHAR(20) NOT NULL,
	name VARCHAR(100) NOT NULL,
	address VARCHAR(100)
);
INSERT INTO spring_member(id,password,name,address)
VALUES('java','a','손흥민','런던');
COMMIT;
SELECT * FROM spring_member;