package com.kkd.orderdetailsservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	ArrayList<String> n=new ArrayList<String>();
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@PostMapping("/details")
	public List<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
		return orderDetailsRepository.findAll();
	}
	
	@GetMapping("/getfarmer/{kkdFarmId}")
	public List<OrderDetails> findOrdersByFarmerId(@PathVariable String kkdFarmId){
		List<OrderDetails> orderDetails=orderDetailsRepository.findAllBykkdFarmId(kkdFarmId);
		return orderDetails;
	}
	
	@DeleteMapping("/deletefarmer/{kkdFarmId}")
	public String deleteOrdersByFarmerId(@PathVariable String kkdFarmId){
		orderDetailsRepository.deleteBykkdFarmId(kkdFarmId);
		return "successfully deleted";
	}
	
	@PutMapping("/update")
	public List<OrderDetails> updateOrdersByFarmerId(@RequestBody OrderDetails orderDetails){
		orderDetailsRepository.save(orderDetails);
		return orderDetailsRepository.findAll();
	}
	
	
	@GetMapping("/getcustomer/{kkdCustId}")
	public List<OrderDetails> findOrdersByCustomerId(@PathVariable String kkdCustId){
		List<OrderDetails> orderDetails=orderDetailsRepository.findAllBykkdCustId(kkdCustId);
		return orderDetails;
	}
		
	
}
