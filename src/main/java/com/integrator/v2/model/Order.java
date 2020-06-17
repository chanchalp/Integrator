package com.integrator.v2.model;


import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author chanchal Prakash
 *
 */
@JsonSerialize
public class Order {

	@JsonProperty("order_number")
	private String orderNumber;

    private List<Shipments> shipments;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<Shipments> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", shipments=" + shipments + "]";
	}

	
    
}
