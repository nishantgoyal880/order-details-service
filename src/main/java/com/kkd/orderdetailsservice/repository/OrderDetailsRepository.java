package com.kkd.orderdetailsservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.kkd.orderdetailsservice.modal.OrderDetails;

public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {
	
	public List<OrderDetails> findAllBykkdFarmId(String kkdFarmId);
	public List<OrderDetails> findAllBykkdCustId(String kkdCustId);
	public OrderDetails findByorderId(String orderId);
	public void deleteByorderId(String orderId);
}
