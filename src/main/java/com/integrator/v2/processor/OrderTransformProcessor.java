package com.integrator.v2.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.integrator.v2.model.Order;
import com.integrator.v2.model.OrderLines;
import com.integrator.v2.model.Shipments;
import com.integrator.v2.model.WmsOrder;

@JsonSerialize
public class OrderTransformProcessor implements Processor {
	
	public static final Logger LOGGER = Logger.getLogger(OrderTransformProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.info("Order Transformation start...");
		List<?> orders=exchange.getIn().getBody(List.class);
		List<WmsOrder> listWmsOrder= new ArrayList<WmsOrder>();
		for(Object o: orders) {
			
			
			for(Shipments shipments:((Order) o).getShipments()) {
				
				for(OrderLines olines: shipments.getOrderLines()) {
					WmsOrder wmsorder = new WmsOrder();
					wmsorder.setOrderId(((Order) o).getOrderNumber());
					wmsorder.setShipmentId(shipments.getShipmentNumber());
					wmsorder.setOrderLineId(olines.getOrderLine());
					wmsorder.setProductId(olines.getProductNumber());
					wmsorder.setPaymentMode(olines.getPaymentMode());
					listWmsOrder.add(wmsorder);
				}
				
			}
			
		}
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		String json = ow.writeValueAsString(listWmsOrder);
		System.out.println(json);
		LOGGER.info("Transforming Request done.");
		exchange.getIn().setBody(listWmsOrder);
	}

}
