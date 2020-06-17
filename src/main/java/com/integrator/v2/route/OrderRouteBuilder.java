package com.integrator.v2.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.RestConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.integrator.v2.config.IntegratorProperties;
import com.integrator.v2.model.Order;
import com.integrator.v2.model.WmsOrder;
import com.integrator.v2.processor.OrderTransformProcessor;

@Component
@JsonSerialize
public class OrderRouteBuilder extends RouteBuilder {
	
	public static final Logger LOGGER = Logger.getLogger(OrderRouteBuilder.class);
	
	@Autowired
	IntegratorProperties Iproperties;
	
	/*
	 * @Autowired CamelContext camelContext;
	 */

	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(WmsOrder.class);
	
	@Override
	public void configure() throws Exception {
		
		// camel servlet configuration
		restConfiguration().component("servlet").bindingMode(RestBindingMode.json);
		/*
		 * RestConfiguration restConfiguration = new RestConfiguration();
		 * restConfiguration.setComponent("servlet");
		 * restConfiguration.setBindingMode(RestConfiguration.RestBindingMode.json);
		 * restConfiguration.setHost("localhost"); restConfiguration.setPort(9800);
		 * 
		 * camelContext.setRestConfiguration(restConfiguration);
		 */
		//restConfiguration().component("servlet").host("localhost").port(9800).bindingMode(RestBindingMode.json);
	
		rest("/api/test")
					.get()
					.route()
					.setBody(constant("Hello World!"));
		
		//Orders - POST API
				rest("/integrator/api/v2").consumes("application/json")
					.produces("application/json")
					.post("/createOrder")
					.type(Order[].class)
					.to("direct:processOrders");
				
		//Code to convert Orders to WareHouseOrder and POST it to WMS
				from("direct:processOrders")
					.process(new OrderTransformProcessor())
					.marshal(jsonDataFormat)
					.process(exchange -> {
						//exchange.getOut().setHeader(Exchange.CONTENT_TYPE, constant("application/json"));
						exchange.getOut().setBody(exchange.getIn().getBody(String.class));
					})
					.setHeader(Exchange.HTTP_METHOD, simple("POST"))
					.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
					.to(Iproperties.getWmsReceiveOrderApiUrl())
					.log("Response from WMS: ${body}");
	}	
		
	}
