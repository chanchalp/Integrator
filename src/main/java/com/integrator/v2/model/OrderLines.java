package com.integrator.v2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author chanchal prakash
 *
 */
public class OrderLines {
	
	@JsonProperty("order_line")
	private String orderLine;

	@JsonProperty("product_number")
    private String productNumber;

	@JsonProperty("payment_mode")
    private String paymentMode;


	public String getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(String orderLine) {
		this.orderLine = orderLine;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderLines [orderLine=" + orderLine + ", productNumber=" + productNumber + ", paymentMode="
				+ paymentMode + "]";
	}

}
