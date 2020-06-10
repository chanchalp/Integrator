package com.integrator.v1.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.integrator.v1.bean.Order;
import com.integrator.v1.bean.OrderLines;
import com.integrator.v1.bean.Response;
import com.integrator.v1.bean.Shipments;
import com.integrator.v1.bean.WmsOrder;
import com.integrator.v1.config.AppProperties;


@Service
public class OrderServiceImpl implements IOrderService{
	
	public static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AppProperties appProperties;

	@Override
	public ResponseEntity<Response> dispatchRequstToWms(List<WmsOrder> listwmsOrder) {
		LOGGER.info("Dispatching request to wms...");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ResponseEntity<Response> response= null;
		try {
			String strJson = ow.writeValueAsString(listwmsOrder);
			HttpEntity<String> request = new HttpEntity<String>(strJson,headers);
			response = restTemplate.postForEntity(appProperties.getWmsReceiveOrderApiUrl(), request, Response.class);
			LOGGER.info("Response code from Wms Service :: "+response.getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public List<WmsOrder> transformOrderRequest(List<Order> orders) throws Exception {
		LOGGER.info("Transforming request start...");
		List<WmsOrder> listWmsOrder= new ArrayList<WmsOrder>();
	//	List<WmsOrderLines> listWmsOrderLines = new ArrayList<WmsOrderLines>();
		WmsOrder wmsOrder = new WmsOrder();
		for(Order o: orders) {
			
			
			for(Shipments shipments:o.getShipments()) {
				
				for(OrderLines olines: shipments.getOrder_lines()) {
					WmsOrder wmsorder = new WmsOrder();
					wmsorder.setOrder_id(o.getOrder_number());
					wmsorder.setShipment_id(shipments.getShipment_number());
					wmsorder.setOrder_line_id(olines.getOrder_line());
					wmsorder.setProd_id(olines.getProduct_number());
					wmsorder.setPayment_mode(olines.getPayment_mode());
					listWmsOrder.add(wmsorder);
				}
				
			}
			//wmsOrder.setWmsOrderLines(listWmsOrderLines);
			
		}
		
		//listWmsOrder.add(wmsOrder);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(listWmsOrder);
		System.out.println(json);
		LOGGER.info("Transforming Request done.");
		return listWmsOrder;
	}

}
