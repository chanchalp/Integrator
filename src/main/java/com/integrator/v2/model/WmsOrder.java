package com.integrator.v2.model;


import java.util.List;

/**
 * 
 * @author chanchal Prakash
 *
 */
public class WmsOrder {
	
	private String order_id;

    private String shipment_id;

    private String order_line_id;

    private String prod_id;

    private String payment_mode;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(String shipment_id) {
		this.shipment_id = shipment_id;
	}

	public String getOrder_line_id() {
		return order_line_id;
	}

	public void setOrder_line_id(String order_line_id) {
		this.order_line_id = order_line_id;
	}

	public String getProd_id() {
		return prod_id;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	@Override
	public String toString() {
		return "WmsOrder [order_id=" + order_id + ", shipment_id=" + shipment_id + ", order_line_id=" + order_line_id
				+ ", prod_id=" + prod_id + ", payment_mode=" + payment_mode + "]";
	}
    
	/*
	 * private List<WmsOrderLines> wmsOrderLines;
	 * 
	 * public List<WmsOrderLines> getWmsOrderLines() { return wmsOrderLines; }
	 * 
	 * public void setWmsOrderLines(List<WmsOrderLines> wmsOrderLines) {
	 * this.wmsOrderLines = wmsOrderLines; }
	 * 
	 * @Override public String toString() { return "WmsOrder [wmsOrderLines=" +
	 * wmsOrderLines + "]"; }
	 */

}
