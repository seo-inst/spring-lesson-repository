package org.kosa.myproject.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kosa.myproject.domain.Product;

@Mapper
public interface ProductMapper {

	int getTotalProductCount();

	List<Product> findAllProductList();

	Product findProductById(Long productId);

	int updateProduct(Product param);

	int registerProduct(Product newProduct);

	List<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

	List<Product> findProductsDynamic(Map<String, Object> searchKeywordMap);

	int updateProductDynamic(Product product);

}












