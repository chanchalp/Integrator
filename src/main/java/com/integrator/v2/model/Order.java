package com.integrator.v2.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author chanchal Prakash
 *
 */
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
