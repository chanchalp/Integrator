package com.integrator.v2.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integrator.v2.config.IntegratorProperties;
import com.integrator.v2.model.Order;
import com.integrator.v2.model.WmsOrder;
import com.integrator.v2.processor.OrderTransformProcessor;

@Component
public class OrderRouteBuilder extends RouteBuilder {
	
	public static final Logger LOGGER = Logger.getLogger(OrderRouteBuilder.class);
	
	@Autowired
	IntegratorProperties Iproperties;

	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(WmsOrder.class);
	
	@Override
	public void configure() throws Exception {
		
		// camel servlet configuration
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);
		

		// route for REST POST Call
		/*
		 * from("file:C:/inboxPOST?noop=true").process(new
		 * OrderTransformProcessor()).marshal(jsonDataFormat)
		 * .setHeader(Exchange.HTTP_METHOD, simple("POST"))
		 * .setHeader(Exchange.CONTENT_TYPE,
		 * constant("application/json")).to(appProperties.getWmsReceiveOrderApiUrl())
		 * .process(new OrderProcessor());
		 */
		
		//Orders - POST API
				rest("integrator/api/v2").consumes("application/json")
					.post("/createOrder")
					.type(Order[].class)
					.to("direct:processOrders");
				
		//Code to convert Orders to WareHouseOrder and POST it to WMS
				from("direct:processOrders")
					.process(new OrderTransformProcessor())
					.marshal(jsonDataFormat)
					.setHeader(Exchange.HTTP_METHOD, simple("POST"))
					.setHeader(Exchange.CONTENT_TYPE, constant("applicatiton/json"))
					.to(Iproperties.getWmsReceiveOrderApiUrl());
	}
		
	}
