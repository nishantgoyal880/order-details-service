package com.kkd.orderdetailsservice.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkd.orderdetailsservice.OrderDetailsServiceApplication;
import com.kkd.orderdetailsservice.modal.OrderDetails;

@Service
public class OrderDetailsService {
		
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	//Service code for updating the order details in database
	public OrderDetails updatingTheOrder(OrderDetails orderDetails,OrderDetails detailsToUpdate) {
		
		if(orderDetails.getAvgRating()!=null){
			detailsToUpdate.setAvgRating(orderDetails.getAvgRating());
			
		}else if(orderDetails.getFarmerStatus()!=null) {
			detailsToUpdate.setFarmerStatus(orderDetails.getFarmerStatus());
			
		}else if(orderDetails.getTransactionId()!=null) {
			detailsToUpdate.setTransactionId(orderDetails.getTransactionId());
			
		}else if(orderDetails.getOrderType()!=null) {
			detailsToUpdate.setOrderType(orderDetails.getOrderType());
			
		}else if(orderDetails.getOrderStatus()!=null) {
			detailsToUpdate.setOrderStatus(orderDetails.getOrderStatus());
			
		}else if(orderDetails.getOtp()!=null) {
			detailsToUpdate.setOtp(orderDetails.getOtp());
			
		}else if(orderDetails.getOrderReceivingDate()!=null) {
			detailsToUpdate.setOrderReceivingDate(orderDetails.getOrderReceivingDate());
			
		}else if(orderDetails.getOrderDeclineReason()!=null) {
			detailsToUpdate.setOrderDeclineReason(orderDetails.getOrderDeclineReason());
			
		}else if(orderDetails.getOtpVerified()==true){
			detailsToUpdate.setOtpVerified(orderDetails.getOtpVerified());
			
		}else {
			
		}
		return detailsToUpdate;
	}
	
	
	//rabbit Mq message generator	
	public void produceMsg(String msg){
		//using the template defining the needed parameters- exchange name,key and message
		amqpTemplate.convertAndSend(OrderDetailsServiceApplication.EXCHANGE_NAME, OrderDetailsServiceApplication.ROUTING_KEY, msg);
		System.out.println("Send msg = " + msg);
	}

}
