package com.integrator.v1.model;


import java.util.List;

/**
 * 
 * @author chanchal Prakash
 *
 */
public class Order {
	private String order_number;

    private List<Shipments> shipments;

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public List<Shipments> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}

	@Override
	public String toString() {
		return "Order [order_number=" + order_number + ", shipments=" + shipments + "]";
	}
    
    
}
