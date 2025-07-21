package org.kosa.myproject.runner;

import java.math.BigDecimal;
import java.util.List;

import org.kosa.myproject.domain.Product;
import org.kosa.myproject.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) // Runner 가 여러개 있을 때 우선순위를 줄 수 있다
public class MyBatisProductDynamicStudyRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisProductDynamicStudyRunner.class);
	// ProductMapper 를 DI 받는다 : private final field , constructor injection
	private final ProductMapper productMapper;

	public MyBatisProductDynamicStudyRunner(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("className {} run.. ProductMapper DI {}", getClass(), productMapper);
		testDynamicFind(); // 첫번째 다이나믹 SQL 검색 테스트 
		testDynamicUpdate();
	}
	void testDynamicUpdate() {
		System.out.println("***Dynamic SQL 을 이용한 수정 테스트***");
		//먼저 업데이트할 상품을 조회한다 
		Product targetProduct = productMapper.findProductById(2L);
		if(targetProduct != null) {
			System.out.println("업데이트 전 상품:"+targetProduct);
			Product product = new Product();
			product.setProductId(2L);
			product.setMaker("Apple");
			product.setProductName("아이패드 에어 7세대");
			product.setPrice(new BigDecimal(1000000));
			int updateCount = productMapper.updateProductDynamic(product);
			System.out.println("업데이트 여부 (1이면 성공)"+ updateCount);
			System.out.println("업데이트 후 상품"+productMapper.findProductById(2L));
		}	   	
	}

	/*
	 * Dynamic SQL 을 이용한 검색 기능 테스트
	 */
	void testDynamicFind() {
		System.out.println("***Dynamic SQL 을 이용한 검색 테스트***");
		// 다양한 검색 데이터들이 있으므로 Map 이 적절
		// 1. 제조사 maker 로만 검색 
//		Map<String, Object> searchKeyword1 = new HashMap<String, Object>();
//		searchKeyword1.put("maker", "삼성");
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword1);
//		printSearchResult(list);
		
		//2. 상품명 부분으로만 검색 
//		Map<String, Object> searchKeyword2 = new HashMap<String, Object>();
//     	searchKeyword2.put("productName", "갤럭시");
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword2);
//		printSearchResult(list);
		
		//3.  1 제조사  2 상품명 부분으로 복합 검색 
//		Map<String, Object> searchKeyword3 = new HashMap<String, Object>();
//     	searchKeyword3.put("productName", "그램");
//     	searchKeyword3.put("maker", "LG");
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword3);
//		printSearchResult(list);
		
		//4.  가격 범위별 검색 (minPrice ~ maxPrice)
//		Map<String, Object> searchKeyword4 = new HashMap<String, Object>();
//     	searchKeyword4.put("minPrice", new BigDecimal("1000000"));
//     	searchKeyword4.put("maxPrice", new BigDecimal("2000000"));
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword4);
//		printSearchResult(list);
		//5.   특정 가격 이하 검색  ( CDATA SECTION 이용)
		/*     Mapper.xml 에서  <=  이 부분이 xml tag가 아니라 <![CDATA[ 영역  ]]   Character Data 임을 알려준다 
		 		<if test="minPrice != null and minPrice !=''">	 		
			 	<![CDATA[
			 	    AND price <= #{minPrice}
			 	]]></if>
		 */
//		Map<String, Object> searchKeyword5 = new HashMap<String, Object>();
//        searchKeyword5.put("searchPrice", new BigDecimal("1000000"));
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword5);
//		printSearchResult(list);
		
		// 6.  maker 와  productName 일부 와  가격 구간으로 복합 검색 
//		Map<String, Object> searchKeyword6 = new HashMap<String, Object>();
//        searchKeyword6.put("minPrice", new BigDecimal("1000000"));
//        searchKeyword6.put("maxPrice", new BigDecimal("3000000"));
//        searchKeyword6.put("maker", "삼성");
//        searchKeyword6.put("productName", "북");
//		List<Product> list = productMapper.findProductsDynamic(searchKeyword6);
//		printSearchResult(list);
	}

	void printSearchResult(List<Product> products) {
		System.out.println("**MyBatis Dynamic SQL 검색 결과**" + products.size() + "개 상품 조회");
		if (products.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		} else {
			products.forEach(product -> System.out.println(product.getProductName() 
					+ " " + product.getMaker()+" "+product.getPrice()));
		}
	}
}







