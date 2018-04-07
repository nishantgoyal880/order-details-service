package com.kkd.orderdetailsservice;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {
	
	public List<OrderDetails> findAllBykkdFarmId(String kkdFarmId);
	public List<OrderDetails> findAllBykkdCustId(String kkdCustId);
	public OrderDetails findByorderId(String orderId);
	public void deleteBykkdFarmId(String kkdFarmId);
}
