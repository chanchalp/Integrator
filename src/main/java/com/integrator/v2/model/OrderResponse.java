package com.integrator.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse {
	
	@JsonProperty("order_number")
	private String orderNumber;
	
	private String message;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
