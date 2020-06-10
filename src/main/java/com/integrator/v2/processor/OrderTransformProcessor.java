package com.integrator.v2.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.integrator.v1.bean.Order;
import com.integrator.v1.bean.OrderLines;
import com.integrator.v1.bean.Shipments;
import com.integrator.v1.bean.WmsOrder;
import com.integrator.v1.service.OrderServiceImpl;

public class OrderTransformProcessor implements Processor {
	
	public static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.info("Order Transformation start...");
		List<?> orders=exchange.getIn().getBody(List.class);
		List<WmsOrder> listWmsOrder= new ArrayList<WmsOrder>();
		for(Object o: orders) {
			
			
			for(Shipments shipments:((Order) o).getShipments()) {
				
				for(OrderLines olines: shipments.getOrder_lines()) {
					WmsOrder wmsorder = new WmsOrder();
					wmsorder.setOrder_id(((Order) o).getOrder_number());
					wmsorder.setShipment_id(shipments.getShipment_number());
					wmsorder.setOrder_line_id(olines.getOrder_line());
					wmsorder.setProd_id(olines.getProduct_number());
					wmsorder.setPayment_mode(olines.getPayment_mode());
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
