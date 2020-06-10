package com.integrator.v1.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.integrator.v1.bean.Order;
import com.integrator.v1.bean.Response;
import com.integrator.v1.bean.WmsOrder;
import com.integrator.v1.service.IOrderService;


/**
 * 
 * @author chanchal prakash
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="integrator/api/v1")
public class OrderController {
	
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	@Autowired
	IOrderService orderService;
	
	/**
	 * 
	 * @param orders
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/createOrder", method=RequestMethod.POST, headers ="Accept=application/json")
	public ResponseEntity<Response> createOrder(@RequestBody List<Order> orders, HttpServletRequest request) throws Exception{
		LOGGER.info("createOrder start... "+orders.toString());
		ResponseEntity<Response> response =null;
		try {
			List<WmsOrder> listWmsOrders = orderService.transformOrderRequest(orders);
			response=orderService.dispatchRequstToWms(listWmsOrders);
		} catch (Exception e) {
			LOGGER.error("Exception occred while creating order :: "+e.getMessage());
			throw new Exception();
		}
		return response;
		
	}

}
