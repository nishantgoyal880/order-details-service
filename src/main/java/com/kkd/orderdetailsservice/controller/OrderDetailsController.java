package com.kkd.orderdetailsservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkd.orderdetailsservice.OrderDetailsServiceApplication;
import com.kkd.orderdetailsservice.modal.OrderDetails;
import com.kkd.orderdetailsservice.repository.OrderDetailsRepository;
import com.kkd.orderdetailsservice.service.OrderDetailsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {

	private static final Logger log = LoggerFactory.getLogger(OrderDetailsServiceApplication.class);
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private OrderDetailsService orderDetailsService;

	// Get the list of all the orders
	@GetMapping("/list")
	@HystrixCommand(fallbackMethod = "getAllOrderDetailsFallback")
	public List<OrderDetails> getAllOrderDetails() {
		//orderDetailsService.produceMsg("getting list of all orders");
		return orderDetailsRepository.findAll();
	}

	// Fallback method for the above mapping
	public List<OrderDetails> getAllOrderDetailsFallback() {
		orderDetailsService.produceMsg("error in getting list of all orders");
		return null;
	}

	// Add the orders in the database
	@PostMapping("/details")
	@HystrixCommand(fallbackMethod = "addOrderDetailsFallback")
	public List<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
		orderDetailsService.produceMsg("Adding data into into the database");
		return orderDetailsRepository.findAll();
	}

	// Fallback method for the above mapping
	public List<OrderDetails> addOrderDetailsFallback(@RequestBody OrderDetails orderDetails) {
		orderDetailsService.produceMsg("error in adding data into the database");
		return null;
	}

	// Get order details according to farmer Id
	@GetMapping("/getfarmer/{kkdFarmId}")
	@HystrixCommand(fallbackMethod = "findOrdersByFarmerIdFallback")
	public List<OrderDetails> findOrdersByFarmerId(@PathVariable String kkdFarmId) {
		List<OrderDetails> orderDetails = orderDetailsRepository.findAllBykkdFarmId(kkdFarmId);
		orderDetailsService.produceMsg("getting list of all orders according to farmer id");
		return orderDetails;
	}

	// Fallback method for the above mapping
	public List<OrderDetails> findOrdersByFarmerIdFallback(@PathVariable String kkdFarmId) {
		orderDetailsService.produceMsg("error in getting list of all orders according to farmer id");
		return null;
	}

	// Mapping for critical changes to be made in database
	@PutMapping("/update")
	@HystrixCommand(fallbackMethod = "updateOrdersByFarmerIdFallback")
	public String updateOrdersByFarmerId(@RequestBody OrderDetails orderDetails) {
		orderDetailsService.produceMsg("updating the details in the database");
		return orderDetailsService.updatingTheOrder(orderDetails);
	}

	// Fallback method for the above mapping
	public String updateOrdersByFarmerIdFallback(@RequestBody OrderDetails orderDetails) {
		orderDetailsService.produceMsg("error in updating the details in the database");
		return null;
	}

	// Get order details according to customer Id
	@GetMapping("/getcustomer/{kkdCustId}")
	@HystrixCommand(fallbackMethod = "findOrdersByCustomerIdFallback")
	public List<OrderDetails> findOrdersByCustomerId(@PathVariable String kkdCustId) {
		List<OrderDetails> orderDetails = orderDetailsRepository.findAllBykkdCustId(kkdCustId);
		orderDetailsService.produceMsg("getting list of all orders according to customer id");
		return orderDetails;
	}

	// Fallback method for the above mapping
	public List<OrderDetails> findOrdersByCustomerIdFallback(@PathVariable String kkdCustId) {
		orderDetailsService.produceMsg("error in getting list of all orders according to customer id");
		return null;
	}

	// Condition where you have to delete the order(Highly restricted access)
	@DeleteMapping("/deleteorder/{orderId}")
	@HystrixCommand(fallbackMethod = "deleteOrdersByIdFallback")
	public String deleteOrdersById(@PathVariable String orderId) {
		orderDetailsRepository.deleteByorderId(orderId);
		orderDetailsService.produceMsg("deleting the order details according to order id");
		return "successfully deleted";
	}

	// Fallback method for the above mapping
	public String deleteOrdersByIdFallback(@PathVariable String orderId) {
		orderDetailsService.produceMsg("error in deleting the order details according to order id");
		return null;
	}

}
