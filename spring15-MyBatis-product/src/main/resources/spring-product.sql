CREATE TABLE spring_product(
	-- 상품 아이디 ( Primary key ,  자동 증가 ) 
	product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	product_name VARCHAR(100) NOT NULL,
	maker VARCHAR(50) NOT NULL,
	price DECIMAL(12,2) NOT NULL DEFAULT 0.00,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- 상품명 검색을 위한 인덱스 
CREATE INDEX idx_spring_product_name ON spring_product(product_name);
-- 제조사별 조회를 위한 인덱스 
CREATE INDEX idx_spring_product_maker ON spring_product(maker);
-- 가격 범위를 위한 인덱스 
CREATE INDEX idx_spring_product_price ON spring_product(price);
-- 등록 일시 정렬을 위한 인덱스 
CREATE INDEX idx_spring_product_created_at ON spring_product(created_at);
-- 복합 인덱스 (제조사 + 가격 조건 검색)
CREATE INDEX idx_spring_product_maker_price ON spring_product(maker,price);

INSERT INTO spring_product (product_name, maker, price) VALUES
('맥북 프로 16인치', 'Apple', 2800000.00),
('아이패드 에어 5세대', 'Apple', 950000.00),
('갤럭시 Z 폴드 6', '삼성', 2500000.00),
('갤럭시 탭 S9', '삼성', 1200000.00),
('LG 그램 17인치', 'LG', 1800000.00),
('LG 스탠바이미', 'LG', 1000000.00),
('소니 WH-1000XM5', 'Sony', 450000.00),
('다이슨 에어랩', 'Dyson', 600000.00),
('샤오미 로봇청소기', '샤오미', 350000.00),
('삼성 비스포크 냉장고', '삼성', 3000000.00);

COMMIT

----- SQL Unit Test -----
select count(*) from spring_product


select product_id, product_name,maker,price,created_at from spring_product

select product_id, product_name,maker,price,created_at 
from spring_product
where price between 500000  and 1000000





















