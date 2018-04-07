package com.kkd.orderdetailsservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orderDetails")
public class OrderDetails {
	
	@Id
	private String kkdFarmId;
	private String productId;
	private String kkdCustId;
	private String name;
	private AddressDetails address;
	private Integer avgRating;
	private String orderId;
	private Integer quantity;
	private String farmerStatus;
	private LocalTime expectedTime;
	private LocalDate expectedDate;
	private String mobileNo;
	private String transactionId;
	private Double totalAmount;
	private String orderType;
	private String orderStatus;
	private String otp;
	private Boolean otpVerified;
	private LocalDate orderPlacingDate;
	private LocalDate orderReceivingDate;
	private LocalDateTime validityOfOrder;
	private String orderDeclineReason;
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(String kkdFarmId, String productId, String kkdCustId, String name, AddressDetails address,
			Integer avgRating, String orderId, Integer quantity, String farmerStatus, LocalTime expectedTime,
			LocalDate expectedDate, String mobileNo, String transactionId, Double totalAmount, String orderType,
			String orderStatus, String otp, Boolean otpVerified, LocalDate orderPlacingDate,
			LocalDate orderReceivingDate, LocalDateTime validityOfOrder, String orderDeclineReason) {
		super();
		this.kkdFarmId = kkdFarmId;
		this.productId = productId;
		this.kkdCustId = kkdCustId;
		this.name = name;
		this.address = address;
		this.avgRating = avgRating;
		this.orderId = orderId;
		this.quantity = quantity;
		this.farmerStatus = farmerStatus;
		this.expectedTime = expectedTime;
		this.expectedDate = expectedDate;
		this.mobileNo = mobileNo;
		this.transactionId = transactionId;
		this.totalAmount = totalAmount;
		this.orderType = orderType;
		this.orderStatus = orderStatus;
		this.otp = otp;
		this.otpVerified = otpVerified;
		this.orderPlacingDate = orderPlacingDate;
		this.orderReceivingDate = orderReceivingDate;
		this.validityOfOrder = validityOfOrder;
		this.orderDeclineReason = orderDeclineReason;
	}

	public String getKkdFarmId() {
		return kkdFarmId;
	}

	public void setKkdFarmId(String kkdFarmId) {
		this.kkdFarmId = kkdFarmId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getKkdCustId() {
		return kkdCustId;
	}

	public void setKkdCustId(String kkdCustId) {
		this.kkdCustId = kkdCustId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

	public Integer getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Integer avgRating) {
		this.avgRating = avgRating;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getFarmerStatus() {
		return farmerStatus;
	}

	public void setFarmerStatus(String farmerStatus) {
		this.farmerStatus = farmerStatus;
	}

	public LocalTime getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(LocalTime expectedTime) {
		this.expectedTime = expectedTime;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Boolean getOtpVerified() {
		return otpVerified;
	}

	public void setOtpVerified(Boolean otpVerified) {
		this.otpVerified = otpVerified;
	}

	public LocalDate getOrderPlacingDate() {
		return orderPlacingDate;
	}

	public void setOrderPlacingDate(LocalDate orderPlacingDate) {
		this.orderPlacingDate = orderPlacingDate;
	}

	public LocalDate getOrderReceivingDate() {
		return orderReceivingDate;
	}

	public void setOrderReceivingDate(LocalDate orderReceivingDate) {
		this.orderReceivingDate = orderReceivingDate;
	}

	public LocalDateTime getValidityOfOrder() {
		return validityOfOrder;
	}

	public void setValidityOfOrder(LocalDateTime validityOfOrder) {
		this.validityOfOrder = validityOfOrder;
	}

	public String getOrderDeclineReason() {
		return orderDeclineReason;
	}

	public void setOrderDeclineReason(String orderDeclineReason) {
		this.orderDeclineReason = orderDeclineReason;
	}

	@Override
	public String toString() {
		return "OrderDetails [kkdFarmId=" + kkdFarmId + ", productId=" + productId + ", kkdCustId=" + kkdCustId
				+ ", name=" + name + ", address=" + address + ", avgRating=" + avgRating + ", orderId=" + orderId
				+ ", Quantity=" + quantity + ", farmerStatus=" + farmerStatus + ", expectedTime=" + expectedTime
				+ ", expectedDate=" + expectedDate + ", mobileNo=" + mobileNo + ", transactionId=" + transactionId
				+ ", totalAmount=" + totalAmount + ", orderType=" + orderType + ", orderStatus=" + orderStatus
				+ ", otp=" + otp + ", otpVerified=" + otpVerified + ", orderPlacingDate=" + orderPlacingDate
				+ ", orderReceivingDate=" + orderReceivingDate + ", validityOfOrder=" + validityOfOrder
				+ ", orderDeclineReason=" + orderDeclineReason + "]";
	}
	
	
	
}
