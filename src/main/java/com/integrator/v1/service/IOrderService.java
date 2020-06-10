package com.integrator.v1.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.integrator.v1.bean.Order;
import com.integrator.v1.bean.Response;
import com.integrator.v1.bean.WmsOrder;


public interface IOrderService {
	
	public List<WmsOrder> transformOrderRequest(List<Order> orders) throws Exception;
	
	public ResponseEntity<Response> dispatchRequstToWms(List<WmsOrder> listwmsOrder) throws Exception;

}
