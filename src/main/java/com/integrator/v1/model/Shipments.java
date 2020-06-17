package com.integrator.v1.model;


import java.util.List;

/**
 * 
 * @author chanchal prakash
 *
 */
public class Shipments {
	private String shipment_number;

    private List<OrderLines> order_lines;

	public String getShipment_number() {
		return shipment_number;
	}

	public void setShipment_number(String shipment_number) {
		this.shipment_number = shipment_number;
	}

	public List<OrderLines> getOrder_lines() {
		return order_lines;
	}

	public void setOrder_lines(List<OrderLines> order_lines) {
		this.order_lines = order_lines;
	}

	@Override
	public String toString() {
		return "Shipments [shipment_number=" + shipment_number + ", order_lines=" + order_lines + "]";
	}
    

}
