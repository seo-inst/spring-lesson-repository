package org.kosa.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.myproject.domain.Customer;

@Mapper
public interface CustomerMapper {
	public int getTotalCount();

	public int register(Customer customer);

	public Customer findById(Long customerId);
}
