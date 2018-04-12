package com.kkd.orderdetailsservice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.kkd.orderdetailsservice.modal.AddressDetails;
import com.kkd.orderdetailsservice.modal.OrderDetails;
import com.kkd.orderdetailsservice.repository.OrderDetailsRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class OrderDetailsServiceApplicationTests {

	@Autowired
	MockMvc mockmvc;

	@MockBean
	OrderDetailsRepository orderDetailsRepository;

	List<OrderDetails> orderDetails=new ArrayList<OrderDetails>();
	OrderDetails mockOrderDetails;
	String expected;
	String expectedArray;
	

	@Before
	public void before() {
		AddressDetails address = new AddressDetails(127306, "306 street A", "dundahera", "gurugram", "haryana");
		mockOrderDetails = new OrderDetails("kkdfarm1001", "kkdprod2001", "kkdcust3001", "nishant", address, 5,
				"kkdord4001", 10, "Accept",LocalTime.of(10, 15, 30), LocalDate.of(2018, 04, 12), "9813887587", "kkdtrans5001", (double) 500, "current",
				"delivered", "5678", true, LocalDate.of(2018, 04, 12), LocalDate.of(2018, 04, 12), LocalDateTime.of(2018, Month.APRIL, 5, 10, 10, 30), "none");
		
		orderDetails.add(mockOrderDetails);
		
		expected="  \" {"
			    + "  \"kkdFarmId\": \"kkdfarm1001\","
			    + "  \"productId\": \"kkdprod2001\","
			    + "  \"kkdCustId\": \"kkdcust3001\","
			    + "  \"name\": \"nishant\","
			    + " \"address\": {"
			    + "  \"pincode\": 127306,"
			    + "  \"addressLine\": \"306 street A\","
			    + " \"city\": \"dundahera\","
			    + "  \"district\": \"gurugram\","
			    + "  \"state\": \"haryana\""
			    + "  },"
			    + "  \"avgRating\": 5,"
			    + "  \"orderId\": \"kkdord4001\","
			    + " \"quantity\": 10,"
			    + "  \"farmerStatus\": \"decline\","
			    + "  \"expectedTime\": \"10:15:30\","
			    + "  \"expectedDate\": \"2018-04-12\","
			    + "  \"mobileNo\": \"9813887587\","
			    + "  \"transactionId\": \"kkdtrans5001\","
			    + "  \"totalAmount\": 500,"
			    + "  \"orderType\": \"current\","
			    + "  \"orderStatus\": \"delivered\","
			    + "  \"otp\": \"5678\","
			    + "  \"otpVerified\": true,"
			    + "  \"orderPlacingDate\": \"2018-04-12\","
			    + "  \"orderReceivingDate\": \"2018-04-12\","
			    + " \"validityOfOrder\": \"2018-04-05T10:10:30\","
			    + "  \"orderDeclineReason\": \"none\""
			    + "  }\" ";
		
		expectedArray=" [ \" {"
			    + "  \"kkdFarmId\": \"kkdfarm1001\","
			    + "  \"productId\": \"kkdprod2001\","
			    + "  \"kkdCustId\": \"kkdcust3001\","
			    + "  \"name\": \"nishant\","
			    + " \"address\": {"
			    + "  \"pincode\": 127306,"
			    + "  \"addressLine\": \"306 street A\","
			    + " \"city\": \"dundahera\","
			    + "  \"district\": \"gurugram\","
			    + "  \"state\": \"haryana\""
			    + "  },"
			    + "  \"avgRating\": 5,"
			    + "  \"orderId\": \"kkdord4001\","
			    + " \"quantity\": 10,"
			    + "  \"farmerStatus\": \"decline\","
			    + "  \"expectedTime\": \"10:15:30\","
			    + "  \"expectedDate\": \"2018-04-12\","
			    + "  \"mobileNo\": \"9813887587\","
			    + "  \"transactionId\": \"kkdtrans5001\","
			    + "  \"totalAmount\": 500,"
			    + "  \"orderType\": \"current\","
			    + "  \"orderStatus\": \"delivered\","
			    + "  \"otp\": \"5678\","
			    + "  \"otpVerified\": true,"
			    + "  \"orderPlacingDate\": \"2018-04-12\","
			    + "  \"orderReceivingDate\": \"2018-04-12\","
			    + " \"validityOfOrder\": \"2018-04-05T10:10:30\","
			    + "  \"orderDeclineReason\": \"none\""
			    + "  }\"]";
		
		
	}
 
	@Test
	public void getAllOrderDetailsTest() throws Exception {

	}

	
	
	//After every test case
	@After
	public void cleanUp() {
		orderDetails = null;
		mockOrderDetails = null;
	}

}
