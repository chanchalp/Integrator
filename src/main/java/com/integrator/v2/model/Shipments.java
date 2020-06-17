package com.integrator.v2.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author chanchal prakash
 *
 */
public class Shipments {
	
	@JsonProperty("shipment_number")
	private String shipmentNumber;

	@JsonProperty("order_lines")
    private List<OrderLines> orderLines;


	public String getShipmentNumber() {
		return shipmentNumber;
	}

	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	public List<OrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Shipments [shipmentNumber=" + shipmentNumber + ", orderLines=" + orderLines + "]";
	}



}
